package br.com.basis.sgt2.Domain;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name ="comentarios")
public class Comentario {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "comentario")
    private String comentario;


}
