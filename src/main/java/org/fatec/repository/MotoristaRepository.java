package org.fatec.repository;

import org.fatec.model.users.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, String> {

}