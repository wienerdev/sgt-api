package br.com.basis.sgt2.dto;

import br.com.basis.sgt2.entities.enums.EnumProgress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TasksDTO implements Serializable {

    private Long id;
    private String title;
    private String description;
    private LocalDate dateTask;
    private EnumProgress progress;
    private Long user;
    List<CommentsDTO> comments;


}
