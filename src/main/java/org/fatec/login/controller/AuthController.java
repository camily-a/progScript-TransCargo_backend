package org.fatec.login.controller;

import org.fatec.login.dto.CadastroDto;
import org.fatec.login.dto.LoginDto;
import org.fatec.login.repository.UsuarioRepository;
import org.fatec.model.users.Administrador;
import org.fatec.model.users.Cliente;
import org.fatec.model.users.Motorista;
import org.fatec.model.users.Usuario;
import org.fatec.repository.AdministradorRepository;
import org.fatec.repository.ClienteRepository;
import org.fatec.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

import static java.util.Objects.nonNull;

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
    private MotoristaRepository motoristaRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

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

        saveUserAndPersonByRole(cadastroDto, user);

        return new ResponseEntity<>("Usuario registrado com sucesso", HttpStatus.OK);

    }

    @Transactional(rollbackFor = SQLException.class)
    private void saveUserAndPersonByRole(CadastroDto cadastroDto, Usuario user) {

        if(nonNull(cadastroDto.getNotificacoes())) {
            Cliente cliente = new Cliente();
            cliente.setCpfCnpj(cadastroDto.getUsername());
            cliente.setNome(cadastroDto.getNome());
            cliente.setEmail(cadastroDto.getEmail());
            cliente.setTelefone(cadastroDto.getTelefone());
            cliente.setPermiteNotificacoes(cadastroDto.getNotificacoes());

            user.setRole("CLIENTE");

            clienteRepository.save(cliente);

        }

        if(nonNull(cadastroDto.getCarteiraMotorista())) {
            Motorista motorista = new Motorista();
            motorista.setCpfCnpj(cadastroDto.getUsername());
            motorista.setNome(cadastroDto.getNome());
            motorista.setEmail(cadastroDto.getEmail());
            motorista.setTelefone(cadastroDto.getTelefone());
            motorista.setCarteiraMotorista(cadastroDto.getCarteiraMotorista());
            motorista.setTipoCarta(cadastroDto.getTipoCarta());
            motorista.setVencimentoCarta(cadastroDto.getVencimentoCarta());

            user.setRole("MOTORISTA");
            motoristaRepository.save(motorista);
        }


        Administrador administrador = new Administrador();
        administrador.setCpfCnpj(cadastroDto.getUsername());
        administrador.setNome(cadastroDto.getNome());
        administrador.setEmail(cadastroDto.getEmail());
        administrador.setTelefone(cadastroDto.getTelefone());
        administrador.setDataAdmissao(cadastroDto.getDataAdmissao());
        administrador.setDataNascimento(cadastroDto.getDataNascimento());
        administrador.setFuncao(cadastroDto.getFuncao());

        user.setRole("ADMINISTRADOR");

        administradorRepository.save(administrador);

        usuarioRepository.save(user);
    }


}