package br.com.basis.sgt.repository;

import br.com.basis.sgt.domain.Comentario;
import br.com.basis.sgt.service.dto.DropDownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findAllByDescricao(String descricao);

    @Query("FROM Comentario WHERE descricao LIKE %:descricao%")
    List<Comentario> encontarTodosPorDescricao(@Param("descricao") String descricao);

    @Query("SELECT new br.com.basis.sgt.service.dto.DropDownDTO(r.id,r.descricao) from Comentario r order by r.descricao asc")
    List<DropDownDTO> getAllComentarioDropDown();
}

