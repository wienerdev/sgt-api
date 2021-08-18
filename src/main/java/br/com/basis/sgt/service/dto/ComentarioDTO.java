package br.com.basis.sgt.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComentarioDTO {

    private Long id;
    private String descricao;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date data;
}
