package br.com.basis.sgt2.repositories;

import br.com.basis.sgt2.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserRepository {



    private Map<Long, User> map = new HashMap<>();


    public void save(User obj){

    map.put(obj.getId(),obj);
    }
    public User findById(Long id){
    return map.get(id);

    }
    public List<User> findAll(){
    return new ArrayList<User>(map.values());

    }



}
