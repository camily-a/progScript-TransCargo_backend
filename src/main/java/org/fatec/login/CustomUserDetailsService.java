package org.fatec.login;

import org.fatec.login.repository.UsuarioRepository;
import org.fatec.model.users.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String doc) throws UsernameNotFoundException {
          Usuario user = usuarioRepository.findByUsername(doc)
                 .orElseThrow(() ->
                         new UsernameNotFoundException("User not found with username "+ doc));

        Set<GrantedAuthority> authorities = Set.of(new SimpleGrantedAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getSenha(),
                authorities);
    }
}