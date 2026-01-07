package com.joinify.backbone.application.service;

import com.joinify.backbone.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

//    @Transactional
//    public AuthResponse login(AuthRequest authRequest) {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
//        return new AuthResponse(jwtUtil.generateToken(userDetails));
//    }

//    @Transactional
//    public AuthResponse register(AuthRequest authRequest) {
//        // save user in bd
//        Usuario nuevoUsuario = new Usuario();
//        nuevoUsuario.setUuid(UUID.randomUUID().toString());
//        nuevoUsuario.setUsername(authRequest.getUsername());
//        nuevoUsuario.setPassword(passwordEncoder.encode(authRequest.getPassword()));
//        userRepository.save(nuevoUsuario);
//
//
//        var aaa = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
//
//        Authentication authentication = authenticationManager.authenticate(aaa);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
//        final String jwt = jwtUtil.generateToken(userDetails);
//
//        return new AuthResponse(jwt);
//    }
}
