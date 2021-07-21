package br.com.basis.sgt2.mapper;

import br.com.basis.sgt2.dto.TasksDTO;
import br.com.basis.sgt2.entities.Tasks;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TasksMapper extends EntityMapper<TasksDTO, Tasks>{

}
