package br.com.basis.sgt2.service;

import br.com.basis.sgt2.dto.UserDTO;
import br.com.basis.sgt2.entities.User;
import br.com.basis.sgt2.mapper.UserMapper;
import br.com.basis.sgt2.repositories.UserRepository;
import br.com.basis.sgt2.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import org.springframework.data.domain.Page;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Transactional(readOnly = true)
    public Page<UserDTO> findByAllPaged(PageRequest pageRequest){
        Page<User> list = repository.findAll(pageRequest);
        return list.map(x -> new UserDTO(x));
    }
    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found !!!"));
        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO insert (UserDTO dto){
        User entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return new UserDTO(entity);
    }
    @Transactional
    public UserDTO update (Long id, UserDTO dto){
        User entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return new UserDTO(entity);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
