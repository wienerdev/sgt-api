package br.com.basis.sgt2.repositories;

import br.com.basis.sgt2.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

    @Query("FROM Tasks WHERE title LIKE %:title%")
    List<Tasks> findAllByTitle(@Param("title") String title);

}
