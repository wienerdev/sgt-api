package br.com.basis.sgt.repository;


import br.com.basis.sgt.domain.TipoTarefa;
import br.com.basis.sgt.service.dto.DropDownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoTarefaRepository extends JpaRepository<TipoTarefa, Long> {

    List<TipoTarefa> findAllByDescricao(String descricao);

    @Query("FROM TipoTarefa WHERE descricao LIKE %:descricao%")
    List<TipoTarefa> encontarTodosDescricao(@Param("descricao") String descricao);

    @Query("SELECT new br.com.basis.sgt.service.dto.DropDownDTO(r.id,r.descricao) from TipoTarefa r order by r.descricao asc")
    List<DropDownDTO> getAllTipoTarefaDropDown();
}

