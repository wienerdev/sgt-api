package br.com.basis.sgt2.mapper;

import br.com.basis.sgt2.dto.UserDTO;
import br.com.basis.sgt2.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper <UserDTO, User> {

}
