package br.com.basis.sgt2.Domain;


import br.com.basis.sgt2.Domain.Enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name ="TAREFAS")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "dataInicio")
    private String dataInicio;

    @Column(name = "teminoPrevisto")
    private String terminoPrevisto;

    @Column(name = "horasEfetivas")
    private String horasEfetivas;

    @Column(name = "status")
    private Status status;

}
