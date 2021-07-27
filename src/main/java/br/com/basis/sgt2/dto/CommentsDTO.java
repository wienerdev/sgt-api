package br.com.basis.sgt2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentsDTO implements Serializable {

    private Long id;
    private String comments;
    private LocalDate dataComment;
}
