package br.com.basis.sgt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "comentario")
@Getter
@Setter
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Timestamp data;

}
