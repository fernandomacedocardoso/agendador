package com.teste.agendador.infra.security;


import com.teste.agendador.business.dto.UsuarioDTO;
import com.teste.agendador.infra.client.UsuarioClient;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl  {

    // Repositório para acessar dados de usuário no banco de dados

    private UsuarioClient client;

    public UserDetails carregaDadosUsuario(String email, String token) {
        UsuarioDTO usuarioDTO = client.buscarUsuarioPorEmail(email, token);

        return User.withUsername(usuarioDTO.getEmail()) // Define o nome de usuário como o e-mail
                .password(usuarioDTO.getSenha()) // Define a senha do usuário
                .build();
    }
}
