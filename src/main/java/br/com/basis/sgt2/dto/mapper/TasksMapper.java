package br.com.basis.sgt2.dto.mapper;

import br.com.basis.sgt2.dto.CommentsDTO;
import br.com.basis.sgt2.dto.TasksDTO;
import br.com.basis.sgt2.entities.Tasks;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CommentsMapper.class)
public interface TasksMapper extends EntityMapper<TasksDTO, Tasks>{

    @Override
    @Mapping(source = "user.id", target = "user")
    TasksDTO toDto(Tasks entity);

    @Override
    @Mapping(source = "user", target = "user.id")
    Tasks toEntity(TasksDTO dto);
}
