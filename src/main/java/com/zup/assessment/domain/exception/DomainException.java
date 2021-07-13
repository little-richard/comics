package com.zup.assessment.domain.exception;

public abstract class DomainException extends Exception{

    public DomainException(String mensagem) {
        super(mensagem);
    }

}
