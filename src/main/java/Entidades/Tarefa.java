package Entidades;


import Enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tarefa {
    private String Datainicio;
    private String TerminoPrevisto;
    private String efetivas;
    private Status st;

}
