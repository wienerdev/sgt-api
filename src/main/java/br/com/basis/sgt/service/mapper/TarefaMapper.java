package br.com.basis.sgt.service.mapper;

import br.com.basis.sgt.domain.Tarefa;
import br.com.basis.sgt.service.dto.TarefaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.mapstruct.Mapper;

@JsonFormat(pattern = "dd/mm/yyyy")
@Mapper(componentModel = "spring", uses = ComentarioMapper.class)
public interface TarefaMapper extends EntityMapper<TarefaDTO, Tarefa> {
}
