package br.com.basis.sgt2.repository;

import br.com.basis.sgt2.Domain.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
    Responsavel findAllById(long id);
}
