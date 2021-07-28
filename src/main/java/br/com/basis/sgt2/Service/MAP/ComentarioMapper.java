package br.com.basis.sgt2.Service.MAP;

import br.com.basis.sgt2.Domain.Comentario;
import br.com.basis.sgt2.Service.DTO.ComentarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComentarioMapper extends EntityMapper<ComentarioDTO, Comentario> {
}
