package br.com.basis.sgt.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {

    private Long id;
    private String titulo;
    private String status;
    private String descricao;
    private TipoTarefaDTO tipoTarefa;
    private ResponsavelDTO responsavel;
    private List<ComentarioDTO> comentarios;

    public void setId(Long id) {
    }
}
