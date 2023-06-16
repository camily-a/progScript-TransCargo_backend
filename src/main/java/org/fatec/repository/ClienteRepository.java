package org.fatec.repository;

import org.fatec.model.users.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    Optional<Cliente> findByCpfCnpj(String doc);
    Boolean existsByCpfCnpj(String doc);

}