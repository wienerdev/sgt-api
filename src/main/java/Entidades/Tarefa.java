package Entidades;


import Enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Tarefa {
    private String Datainicio;
    private String TerminoPrevisto;
    private String efetivas;
    private Status st;

}
