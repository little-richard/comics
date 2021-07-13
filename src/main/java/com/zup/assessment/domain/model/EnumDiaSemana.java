package com.zup.assessment.domain.model;

import lombok.Getter;

import java.time.DayOfWeek;

@Getter
public enum EnumDiaSemana {

    SEGUNDA("Segunda-feira", DayOfWeek.MONDAY),
    TERCA("Terça-feira", DayOfWeek.TUESDAY),
    QUARTA("Quarta-feira", DayOfWeek.WEDNESDAY),
    QUINTA("Quinta-feira", DayOfWeek.THURSDAY),
    SEXTA("Sexta-feira", DayOfWeek.FRIDAY),
    DOMINGO("Sexta-feira", DayOfWeek.SUNDAY);

    private final String descricao;
    private final DayOfWeek dayOfWeek;

    EnumDiaSemana(String descricao, DayOfWeek dayOfWeek) {
        this.descricao = descricao;
        this.dayOfWeek = dayOfWeek;
    }

}
