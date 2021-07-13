package com.zup.assessment.infra.rest.client;

import com.zup.assessment.infra.rest.client.dto.ComicDataWrapperDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://gateway.marvel.com/v1/public/comics", name = "marvel")
public interface MarvelAPIClient {

    @GetMapping("/{comicId}")
    ComicDataWrapperDTO consultarComicPorId(@RequestParam("ts") String ts,
                                            @RequestParam("apikey") String apikey,
                                            @RequestParam("hash") String hash,
                                            @PathVariable("comicId") String comicId);

}
