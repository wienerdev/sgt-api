package br.com.basis.sgt.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class ComentarioDTO {

    private Long id;
    private String descricao;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date data;

    private List<ComentarioDTO> comentarios;
}
