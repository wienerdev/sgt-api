package br.com.basis.sgt.service.dto;

import br.com.basis.sgt.domain.Comentario;
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
    private String descricao;
    private TipoTarefaDTO tipoTarefa;
    private List<ComentarioDTO> comentarios;
}
