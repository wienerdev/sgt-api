package br.com.basis.sgt2.dto.mapper;

import br.com.basis.sgt2.dto.CommentsDTO;
import br.com.basis.sgt2.entities.Comments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface CommentsMapper extends EntityMapper<CommentsDTO, Comments>{
}
