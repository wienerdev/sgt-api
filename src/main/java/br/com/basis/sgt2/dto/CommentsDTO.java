package br.com.basis.sgt2.dto;

import br.com.basis.sgt2.entities.Tasks;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CommentsDTO {

    private Long id;
    private String comments;
    private Tasks tasks;

}
