package com.zup.assessment.application.service;

import com.sun.istack.NotNull;
import com.zup.assessment.application.common.MD5Util;
import com.zup.assessment.domain.exception.AutorException;
import com.zup.assessment.domain.exception.ComicException;
import com.zup.assessment.domain.model.Autor;
import com.zup.assessment.domain.model.Comic;
import com.zup.assessment.domain.service.ComicService;
import com.zup.assessment.infra.rest.client.MarvelAPIClient;
import com.zup.assessment.infra.rest.client.dto.ComicDataWrapperDTO;
import com.zup.assessment.infra.rest.client.dto.ComicResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ComicServiceImpl implements ComicService {

    @Value("${app.assessment.marvel.publickey}")
    String PUBLIC_KEY;

    @Value("${app.assessment.marvel.privatekey}")
    String PRIVATE_KEY;

    private final MarvelAPIClient marvelAPIClient;

    public ComicServiceImpl(@Lazy @NotNull MarvelAPIClient marvelAPIClient) {

        this.marvelAPIClient = marvelAPIClient;

    }

    @Override
    public Comic consultarPorId(String id) throws ComicException {

        final Long TS = Timestamp.from(Instant.now()).getTime();
        final String HASH = MD5Util.hash(TS + PRIVATE_KEY + PUBLIC_KEY);

        ComicDataWrapperDTO comicDataWrapperDTO = marvelAPIClient.consultarComicPorId(String.valueOf(TS), PUBLIC_KEY, HASH, id);

        return convertFromComicReponseToDomain(comicDataWrapperDTO);

    }

    private Comic convertFromComicReponseToDomain(ComicDataWrapperDTO comicDataWrapperDTO) throws ComicException {

        Comic comicReturn = null;

        if(Objects.nonNull(comicDataWrapperDTO)
                && Objects.nonNull(comicDataWrapperDTO.getData())
                && Objects.nonNull(comicDataWrapperDTO.getData().getResults())
                && !comicDataWrapperDTO.getData().getResults().isEmpty()){

            ComicResponseDTO comicResponseDTO = comicDataWrapperDTO.getData().getResults().get(0);

            Long comicId = comicResponseDTO.getId().longValue();
            String descricao = comicResponseDTO.getDescription();
            String isbn = comicResponseDTO.getIsbn();
            String titulo = comicResponseDTO.getTitle();

            List<Autor> autores = comicResponseDTO.getCreators().getItems()
                    .stream()
                    .map(obj-> {
                        try {
                            return new Autor.Builder()
                                    .nome(obj.getName())
                                    .cargo(obj.getRole())
                                    .build();
                        } catch (AutorException e) {
                            return null;
                        }
                    })
                    .collect(Collectors.toList());

            BigDecimal preco = comicResponseDTO.getPrices().get(0).getPrice();

            comicReturn = new Comic.ComicBuilder()
                    .id(comicId)
                    .descricao(descricao)
                    .isbn(isbn)
                    .titulo(titulo)
                    .preco(preco)
                    .autores(autores)
                    .build();

        }

        return comicReturn;

    }

}
