package br.com.basis.sgt.service.mapper;

import br.com.basis.sgt.domain.Tarefa;
import br.com.basis.sgt.service.dto.TarefaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T10:10:44-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class TarefaMapperImpl implements TarefaMapper {

    @Override
    public Tarefa toEntity(TarefaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tarefa tarefa = new Tarefa();

        tarefa.setId( dto.getId() );
        tarefa.setTitulo( dto.getTitulo() );

        return tarefa;
    }

    @Override
    public TarefaDTO toDto(Tarefa entity) {
        if ( entity == null ) {
            return null;
        }

        TarefaDTO tarefaDTO = new TarefaDTO();

        tarefaDTO.setId( entity.getId() );
        tarefaDTO.setTitulo( entity.getTitulo() );

        return tarefaDTO;
    }

    @Override
    public List<Tarefa> toEntity(List<TarefaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Tarefa> list = new ArrayList<Tarefa>( dtoList.size() );
        for ( TarefaDTO tarefaDTO : dtoList ) {
            list.add( toEntity( tarefaDTO ) );
        }

        return list;
    }

    @Override
    public List<TarefaDTO> toDto(List<Tarefa> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TarefaDTO> list = new ArrayList<TarefaDTO>( entityList.size() );
        for ( Tarefa tarefa : entityList ) {
            list.add( toDto( tarefa ) );
        }

        return list;
    }
}
