package org.fatec.login.controller;

import org.aspectj.apache.bcel.generic.InstructionConstants;
import org.fatec.login.dto.CadastroDto;
import org.fatec.login.dto.LoginDto;
import org.fatec.login.repository.UsuarioRepository;
import org.fatec.model.Cliente;
import org.fatec.model.Usuario;
import org.fatec.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getSenha()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("Usuário logado com successo!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody CadastroDto cadastroDto){

        if(usuarioRepository.existsByUsername(cadastroDto.getUsername())){
            return new ResponseEntity<>("Username já está cadastrado!", HttpStatus.BAD_REQUEST);
        }

        Usuario user = new Usuario();
        user.setUsername(cadastroDto.getUsername());
        user.setSenha(passwordEncoder.encode(cadastroDto.getSenha()));
        user.setRole("CLIENTE");

        Cliente cliente = new Cliente();
        cliente.setCpfCnpj(cadastroDto.getUsername());
        cliente.setNome(cadastroDto.getNome());
        cliente.setEmail(cadastroDto.getEmail());
        cliente.setTelefone(cadastroDto.getTelefone());
        cliente.setPermiteNotificacoes(cadastroDto.getNotificacoes());


        usuarioRepository.save(user);
        clienteRepository.save(cliente);

        return new ResponseEntity<>("Usuario registrado com sucesso", HttpStatus.OK);

    }


}