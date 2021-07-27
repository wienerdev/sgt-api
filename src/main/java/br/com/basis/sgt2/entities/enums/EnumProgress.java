package br.com.basis.sgt2.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumProgress {

    TO_DO("To do"), DOING("Doing"),DONE("Done");

    private String description;

}
