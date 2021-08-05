package br.com.basis.sgt.service.mapper;

import br.com.basis.sgt.domain.Responsavel;
import br.com.basis.sgt.service.dto.ResponsavelDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-05T09:23:18-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class ResponsavelMapperImpl implements ResponsavelMapper {

    @Override
    public Responsavel toEntity(ResponsavelDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Responsavel responsavel = new Responsavel();

        responsavel.setId( dto.getId() );
        responsavel.setSetor( dto.getSetor() );

        return responsavel;
    }

    @Override
    public ResponsavelDTO toDto(Responsavel entity) {
        if ( entity == null ) {
            return null;
        }

        ResponsavelDTO responsavelDTO = new ResponsavelDTO();

        responsavelDTO.setId( entity.getId() );
        responsavelDTO.setSetor( entity.getSetor() );

        return responsavelDTO;
    }

    @Override
    public List<Responsavel> toEntity(List<ResponsavelDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Responsavel> list = new ArrayList<Responsavel>( dtoList.size() );
        for ( ResponsavelDTO responsavelDTO : dtoList ) {
            list.add( toEntity( responsavelDTO ) );
        }

        return list;
    }

    @Override
    public List<ResponsavelDTO> toDto(List<Responsavel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ResponsavelDTO> list = new ArrayList<ResponsavelDTO>( entityList.size() );
        for ( Responsavel responsavel : entityList ) {
            list.add( toDto( responsavel ) );
        }

        return list;
    }
}
