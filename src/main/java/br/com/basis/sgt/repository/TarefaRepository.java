package br.com.basis.sgt.repository;


import br.com.basis.sgt.domain.Tarefa;
import br.com.basis.sgt.service.dto.DropDownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findAllByTitulo(String comentario);

    @Query("FROM Tarefa WHERE titulo LIKE %:titulo%")
    List<Tarefa> encontarTodosPorTitulo(@Param("titulo") String titulo);



     @Query("SELECT new br.com.basis.sgt.service.dto.DropDownDTO(r.id,r.titulo) from Tarefa r order by r.titulo asc")
     List<DropDownDTO> getAllTarefaDropDown();
}
