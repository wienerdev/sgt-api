package br.com.basis.sgt2.resources;


import br.com.basis.sgt2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.basis.sgt2.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/users")

public class UserResources {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>>findAll(){
        List<User> list = userRepository.findAll();
        list.add(new User(1L, "Caio", "agronomocaredoso@gmail.com"));
        list.add(new User(2L,"Osorio","osorio21@gmail.com"));
        return ResponseEntity.ok().body(list);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
    User user = userRepository.findById(id);
      return ResponseEntity.ok().body(user);
    }






}
