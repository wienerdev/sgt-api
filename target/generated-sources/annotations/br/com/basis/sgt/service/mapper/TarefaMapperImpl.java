package br.com.basis.sgt.service.mapper;

import br.com.basis.sgt.domain.Tarefa;
import br.com.basis.sgt.service.dto.TarefaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-19T09:23:29-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class TarefaMapperImpl implements TarefaMapper {

    @Autowired
    private ComentarioMapper comentarioMapper;
    @Autowired
    private TipoTarefaMapper tipoTarefaMapper;
    @Autowired
    private ResponsavelMapper responsavelMapper;

    @Override
    public Tarefa toEntity(TarefaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tarefa tarefa = new Tarefa();

        tarefa.setId( dto.getId() );
        tarefa.setTitulo( dto.getTitulo() );
        tarefa.setDescricao( dto.getDescricao() );
        tarefa.setStatus( dto.getStatus() );
        tarefa.setTipoTarefa( tipoTarefaMapper.toEntity( dto.getTipoTarefa() ) );
        tarefa.setResponsavel( responsavelMapper.toEntity( dto.getResponsavel() ) );
        tarefa.setComentarios( comentarioMapper.toEntity( dto.getComentarios() ) );

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
        tarefaDTO.setStatus( entity.getStatus() );
        tarefaDTO.setDescricao( entity.getDescricao() );
        tarefaDTO.setTipoTarefa( tipoTarefaMapper.toDto( entity.getTipoTarefa() ) );
        tarefaDTO.setResponsavel( responsavelMapper.toDto( entity.getResponsavel() ) );
        tarefaDTO.setComentarios( comentarioMapper.toDto( entity.getComentarios() ) );

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
