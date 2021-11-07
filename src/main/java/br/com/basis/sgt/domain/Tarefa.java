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

    @JoinColumn(name = "id_tipo", nullable = false)
    @ManyToOne
    private TipoTarefa tipoTarefa;

    @JoinColumn(name = "id_responsavel", nullable = false)
    @ManyToOne
    private Responsavel responsavel;

    @JoinColumn(name = "id_tarefa")
    @OneToMany(fetch = FetchType.LAZY)
    List<Comentario> comentarios;



}
