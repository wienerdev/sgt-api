package br.com.basis.sgt2.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tb_comments")
public class Comments implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "id_tasks")
    private Tasks tasks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return id.equals(comments.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
