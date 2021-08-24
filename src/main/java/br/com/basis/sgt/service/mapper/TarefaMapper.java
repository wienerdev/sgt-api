package br.com.basis.sgt.service.mapper;

import br.com.basis.sgt.domain.Tarefa;
import br.com.basis.sgt.domain.TipoTarefa;
import br.com.basis.sgt.service.dto.TarefaDTO;
import br.com.basis.sgt.service.dto.TipoTarefaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.mapstruct.Mapper;

@JsonFormat(pattern = "dd/mm/yyyy")
@Mapper(componentModel = "spring", uses = {ComentarioMapper.class, TipoTarefaMapper.class,ResponsavelMapper.class} )
public interface TarefaMapper extends EntityMapper<TarefaDTO, Tarefa> {
}
