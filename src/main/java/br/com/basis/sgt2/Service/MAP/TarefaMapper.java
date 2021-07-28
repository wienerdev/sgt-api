package br.com.basis.sgt2.Service.MAP;

import br.com.basis.sgt2.Domain.Tarefa;
import br.com.basis.sgt2.Service.DTO.TarefaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",  uses = ComentarioMapper.class)
public interface TarefaMapper extends EntityMapper<TarefaDTO, Tarefa>{
}
