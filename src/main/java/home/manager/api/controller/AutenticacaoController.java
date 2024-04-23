package home.manager.api.controller;

import home.manager.api.config.SecurityConfigurations;
import home.manager.api.model.user.dto.UserRequest;
import home.manager.api.model.user.dto.UserResponse;
import home.manager.api.model.user.entity.User;
import home.manager.api.repository.UserRepository;
import home.manager.api.service.authentication.TokenService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private SecurityConfigurations security;

    @Autowired
    private UserRepository repository;

    @PostMapping("/create")
    public ResponseEntity criarUsuario(@RequestBody @Valid UserRequest dados, UriComponentsBuilder uriBuilder){
        var user = new User(dados.login(), security.passwordEncoder().encode(dados.password()));
        repository.save(user);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user).toUri();
        return ResponseEntity.created(uri).body("usuario criado");
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid UserRequest dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new UserResponse(tokenJWT));
    }
}
