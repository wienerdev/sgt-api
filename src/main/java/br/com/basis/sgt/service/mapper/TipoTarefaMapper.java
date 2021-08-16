package br.com.basis.sgt.service.mapper;

import br.com.basis.sgt.domain.TipoTarefa;
import br.com.basis.sgt.service.dto.TipoTarefaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TarefaMapper.class)
public interface TipoTarefaMapper extends EntityMapper<TipoTarefaDTO, TipoTarefa> {
}
