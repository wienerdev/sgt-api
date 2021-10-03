package br.com.basis.sgt.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoTarefaDTO {

    private Long id;
    private String descricao;

    public void setId(Long id) {
    }
}
