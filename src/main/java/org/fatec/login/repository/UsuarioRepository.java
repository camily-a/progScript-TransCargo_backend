package org.fatec.login.repository;


import org.fatec.model.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByUsername(String username);
    Boolean existsByUsername(String username);
}