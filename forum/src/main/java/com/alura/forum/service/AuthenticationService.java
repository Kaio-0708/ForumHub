package com.alura.forum.service;

import com.alura.forum.infra.security.TokenService;
import com.alura.forum.model.dto.request.LoginDTO;
import com.alura.forum.model.dto.request.RegisterDTO;
import com.alura.forum.model.entity.User;
import com.alura.forum.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    public String login(LoginDTO dados, AuthenticationManager manager) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
        var autentication = manager.authenticate(token);
        return tokenService.gerarToken((User) autentication.getPrincipal());
    }

    public void register(RegisterDTO dados) {
        User user = new User();
        user.setName(dados.name());
        user.setLogin(dados.login());
        user.setPassword(passwordEncoder.encode(dados.password()));
        userRepository.save(user);
    }

}
