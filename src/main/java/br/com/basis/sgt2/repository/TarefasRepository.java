package br.com.basis.sgt2.repository;

import br.com.basis.sgt2.Domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TarefasRepository extends JpaRepository<Tarefa, Long> {
    Tarefa findAllById(long id);
}
