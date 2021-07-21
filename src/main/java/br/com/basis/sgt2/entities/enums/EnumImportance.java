package br.com.basis.sgt2.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EnumImportance {

    IMPORTANT("Important"), ESSENTIAL("Essential"), REASONABLE("Reasonable");

    private String description;

}