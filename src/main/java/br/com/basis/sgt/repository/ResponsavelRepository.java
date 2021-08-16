package br.com.basis.sgt.repository;


import br.com.basis.sgt.domain.Responsavel;
import br.com.basis.sgt.service.dto.DropDownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

    List<Responsavel> findAllBySetor(String setor);

    @Query("FROM Responsavel WHERE setor LIKE %:setor%")
    List<Responsavel> encontarTodosPorSetor(@Param("setor") String setor);

    @Query("SELECT new br.com.basis.sgt.service.dto.DropDownDTO(r.id,r.setor) from Responsavel r order by r.setor asc")
    List<DropDownDTO> getAllResponsaveisDropDown();
}

