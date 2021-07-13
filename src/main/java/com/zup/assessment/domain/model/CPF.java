package com.zup.assessment.domain.model;

import com.zup.assessment.domain.exception.CPFException;
import com.zup.assessment.domain.validator.CPFValidator;

public class CPF {

    private final String numero;

    public CPF(String numero) throws CPFException {

        this.numero = numero;

        CPFValidator.validar(this);

    }

    public String getNumero(){
        return numero;
    }

}
