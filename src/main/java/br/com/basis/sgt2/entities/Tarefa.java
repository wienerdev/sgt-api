package br.com.basis.sgt2.entities;

import br.com.basis.sgt2.entities.enums.EnumImportance;
import br.com.basis.sgt2.entities.enums.EnumProgress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tarefa {

    private Long id;
    private String name;
    private String description;
    private EnumImportance importance;
    private EnumProgress progress;
    private User user;

}