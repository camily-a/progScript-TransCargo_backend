package org.fatec.repository;

import org.fatec.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaminhaoRepository extends JpaRepository<Caminhao, String> {
    Optional<Caminhao> findByPlaca(String placa);
}
