package br.com.basis.sgt.service.mapper;

import br.com.basis.sgt.domain.Comentario;
import br.com.basis.sgt.service.dto.ComentarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-02T17:19:27-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_302 (Amazon.com Inc.)"
)
@Component
public class ComentarioMapperImpl implements ComentarioMapper {

    @Override
    public Comentario toEntity(ComentarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Comentario comentario = new Comentario();

        comentario.setId( dto.getId() );
        comentario.setDescricao( dto.getDescricao() );
        comentario.setData( dto.getData() );

        return comentario;
    }

    @Override
    public ComentarioDTO toDto(Comentario entity) {
        if ( entity == null ) {
            return null;
        }

        ComentarioDTO comentarioDTO = new ComentarioDTO();

        comentarioDTO.setId( entity.getId() );
        comentarioDTO.setDescricao( entity.getDescricao() );
        comentarioDTO.setData( entity.getData() );

        return comentarioDTO;
    }

    @Override
    public List<Comentario> toEntity(List<ComentarioDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Comentario> list = new ArrayList<Comentario>( dtoList.size() );
        for ( ComentarioDTO comentarioDTO : dtoList ) {
            list.add( toEntity( comentarioDTO ) );
        }

        return list;
    }

    @Override
    public List<ComentarioDTO> toDto(List<Comentario> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ComentarioDTO> list = new ArrayList<ComentarioDTO>( entityList.size() );
        for ( Comentario comentario : entityList ) {
            list.add( toDto( comentario ) );
        }

        return list;
    }
}
