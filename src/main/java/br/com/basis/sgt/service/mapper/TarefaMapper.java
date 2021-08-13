package br.com.basis.sgt.service.mapper;

import br.com.basis.sgt.domain.Tarefa;
import br.com.basis.sgt.service.dto.TarefaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.mapstruct.Mapper;

/**
 * Faz a conversão de DTO para entidade
 * o 'uses' é usado devido à TarefaDTO possuir um DTO dentro dela
 */

@JsonFormat(pattern = "dd/mm/yyyy")
@Mapper(componentModel = "spring", uses = ComentarioMapper.class)
public interface TarefaMapper extends EntityMapper<TarefaDTO, Tarefa> {
}
