package br.com.basis.sgt2.dto;

import br.com.basis.sgt2.entities.Tasks;
import br.com.basis.sgt2.entities.User;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long idUser;
    private String name;
    private String email;

//    private List<Tasks> tasks = new ArrayList<>();

    public UserDTO(User entity) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
//        this.tasks = tasks;
    }
}
