package Entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Responsavel {

    private long id;
    private String nome;

}
