package br.com.basis.sgt2.Domain;


import br.com.basis.sgt2.Domain.Enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name ="tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "termino_previsto")
    private LocalDate terminoPrevisto;

    @Column(name = "horas_efetivas")
    private int horasEfetivas;

    @Column(name = "status")
    private Status status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "id_tarefa")
    private List<Comentario> comentario;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Responsavel responsavel;
}
