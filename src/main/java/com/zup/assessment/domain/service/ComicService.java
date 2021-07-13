package com.zup.assessment.domain.service;

import com.zup.assessment.domain.exception.ComicException;
import com.zup.assessment.domain.model.Comic;

public interface ComicService {

    Comic consultarPorId(String id) throws ComicException;

}
