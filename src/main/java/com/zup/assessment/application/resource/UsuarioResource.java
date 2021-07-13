package com.zup.assessment.application.resource;

import com.zup.assessment.application.resource.dto.UsuarioDTO;
import com.zup.assessment.application.resource.mapper.RestMapper;
import com.zup.assessment.domain.exception.CPFException;
import com.zup.assessment.domain.exception.UsuarioException;
import com.zup.assessment.domain.model.CPF;
import com.zup.assessment.domain.model.Comic;
import com.zup.assessment.domain.model.Usuario;
import com.zup.assessment.domain.service.ComicService;
import com.zup.assessment.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioResource {

    private final String BASE_URL = "/usuario";

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ComicService comicService;

    @PostMapping( BASE_URL + "/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioDTO usuarioDTO) {

        try{

            Usuario usuario = new Usuario.UsuarioBuilder()
                    .nome(usuarioDTO.getNome())
                    .dataNascimento(LocalDate.parse(usuarioDTO.getDataNascimento()))
                    .email(usuarioDTO.getEmail())
                    .cpf(new CPF(usuarioDTO.getCpf()))
                    .build();

            this.usuarioService.cadastrar(usuario);

            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.badRequest().build();

        }

    }

    @PostMapping( BASE_URL + "/{usuarioId}/cadastrar-comic/{comicId}")
    public ResponseEntity<?> cadastrarComic(@PathVariable Long usuarioId,
                                            @PathVariable Long comicId) {

        try{

            Comic comic = this.comicService.consultarPorId(String.valueOf(comicId));
            Usuario usuario = this.usuarioService.consultarPorId(usuarioId);

            this.usuarioService.cadastrarComic(usuario, comic);

            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.badRequest().build();

        }

    }


    @GetMapping(BASE_URL + "/consultar/{id}")
    public ResponseEntity<?> consultar(@PathVariable Long id) {
        try {

            Usuario usuario = this.usuarioService.consultarPorId(id);

            return ResponseEntity.ok(RestMapper.convertToUsuarioDTOFromUsuario(usuario));

        } catch (UsuarioException | CPFException e) {
            e.printStackTrace();

            return ResponseEntity.badRequest().build();

        }
    }
}
