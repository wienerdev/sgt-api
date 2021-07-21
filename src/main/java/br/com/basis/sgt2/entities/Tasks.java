package br.com.basis.sgt2.entities;

import br.com.basis.sgt2.entities.enums.EnumImportance;
import br.com.basis.sgt2.entities.enums.EnumProgress;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tb_tasks")
public class Tasks implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "importance")
    private EnumImportance importance;

    @Column(name = "progress")
    private EnumProgress progress;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "tasks")
    public List<Comments> comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return Objects.equals(id, tasks.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}