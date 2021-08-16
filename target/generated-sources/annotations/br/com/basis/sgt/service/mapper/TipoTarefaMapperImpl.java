package br.com.basis.sgt.service.mapper;

import br.com.basis.sgt.domain.TipoTarefa;
import br.com.basis.sgt.service.dto.TipoTarefaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-16T10:43:57-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class TipoTarefaMapperImpl implements TipoTarefaMapper {

    @Override
    public TipoTarefa toEntity(TipoTarefaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipoTarefa tipoTarefa = new TipoTarefa();

        tipoTarefa.setId( dto.getId() );
        tipoTarefa.setDescricao( dto.getDescricao() );

        return tipoTarefa;
    }

    @Override
    public TipoTarefaDTO toDto(TipoTarefa entity) {
        if ( entity == null ) {
            return null;
        }

        TipoTarefaDTO tipoTarefaDTO = new TipoTarefaDTO();

        tipoTarefaDTO.setId( entity.getId() );
        tipoTarefaDTO.setDescricao( entity.getDescricao() );

        return tipoTarefaDTO;
    }

    @Override
    public List<TipoTarefa> toEntity(List<TipoTarefaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TipoTarefa> list = new ArrayList<TipoTarefa>( dtoList.size() );
        for ( TipoTarefaDTO tipoTarefaDTO : dtoList ) {
            list.add( toEntity( tipoTarefaDTO ) );
        }

        return list;
    }

    @Override
    public List<TipoTarefaDTO> toDto(List<TipoTarefa> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TipoTarefaDTO> list = new ArrayList<TipoTarefaDTO>( entityList.size() );
        for ( TipoTarefa tipoTarefa : entityList ) {
            list.add( toDto( tipoTarefa ) );
        }

        return list;
    }
}
