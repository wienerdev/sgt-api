package br.com.basis.sgt.service.mapper;

import br.com.basis.sgt.domain.Comentario;
import br.com.basis.sgt.service.dto.ComentarioDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.mapstruct.Mapper;

@JsonFormat(pattern = "dd/mm/yyyy")
@Mapper(componentModel = "spring")
public interface ComentarioMapper extends EntityMapper<ComentarioDTO, Comentario> {
}
