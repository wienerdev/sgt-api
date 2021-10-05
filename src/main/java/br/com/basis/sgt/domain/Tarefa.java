package br.com.basis.sgt.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private String status;

    @JoinColumn(name = "id_tipo")
    @ManyToOne(cascade = CascadeType.ALL)
    private TipoTarefa tipoTarefa;

    @JoinColumn(name = "id_responsavel")
    @ManyToOne(cascade = CascadeType.ALL)
    private Responsavel responsavel;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_tarefa")
    List<Comentario> comentarios;



}
