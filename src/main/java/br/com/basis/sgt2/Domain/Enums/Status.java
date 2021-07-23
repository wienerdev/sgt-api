package br.com.basis.sgt2.Domain.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    A_FAZER(1), FAZENDO(2), FEITO(3);

    private int code;



}
