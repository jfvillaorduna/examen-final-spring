package com.examenfinal.ms_auth.service;

import com.examenfinal.ms_auth.dto.AuthResponse;
import com.examenfinal.ms_auth.dto.LoginRequest;
import com.examenfinal.ms_auth.dto.RegistroRequest;
import com.examenfinal.ms_auth.entity.Usuario;
import com.examenfinal.ms_auth.repository.UsuarioRepository;
import com.examenfinal.ms_auth.secutiry.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthResponse register(RegistroRequest request) {
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .rol(request.getRol())
                .build();

        usuarioRepository.save(usuario);
        String token = jwtService.generateToken(usuario);
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(request.getEmail());

        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Usuario usuario = usuarioOpt.get();
        boolean validPassword = encoder.matches(request.getPassword(), usuario.getPassword());

        if (!validPassword) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtService.generateToken(usuario);
        return new AuthResponse(token);
    }
}