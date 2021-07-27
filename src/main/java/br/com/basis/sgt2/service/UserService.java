package br.com.basis.sgt2.service;

import br.com.basis.sgt2.dto.UserDTO;
import br.com.basis.sgt2.dto.mapper.UserMapper;
import br.com.basis.sgt2.entities.User;
import br.com.basis.sgt2.repositories.UserRepository;
import br.com.basis.sgt2.service.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> findAll() {
        return userMapper.toDto(userRepository.findAll());
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return userMapper.toDto(user);
    }

    public UserDTO save(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User saveUser = userRepository.save(user);
        return userMapper.toDto(saveUser);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
