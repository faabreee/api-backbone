package com.joinify.backbone.infrastructure.controller;

import com.joinify.backbone.application.service.AuthService;
import com.joinify.backbone.domain.valueobject.ResponseDtoCode;
import com.joinify.backbone.infrastructure.dto.request.AuthRequest;
import com.joinify.backbone.infrastructure.dto.response.AuthResponse;
import com.joinify.backbone.infrastructure.dto.response.ResponseDto;
import com.joinify.backbone.infrastructure.validator.AuthValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthValidator authValidator;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDto<AuthResponse>> createToken(@RequestBody AuthRequest authRequest) {
        ResponseDto<AuthResponse> responseDto = new ResponseDto<>();

        try {
//            AuthResponse authResponse = authService.login(authRequest);

            responseDto.setCode(ResponseDtoCode.SUCCESS.getCode());
            responseDto.setMessage("Login realizado correctamente!");
//            responseDto.setResponse(authResponse);

            return ResponseEntity.status(HttpStatus.OK.value()).body(responseDto);
        } catch (AuthenticationException e) {
            System.out.println("Error de autenticación: " + e);
            responseDto.setCode(ResponseDtoCode.ERROR.getCode());
            responseDto.setMessage("Credenciales inválidas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDto);
        } catch (Exception e) {
            System.out.println("Error de autenticación: " + e);
            responseDto.setCode(ResponseDtoCode.ERROR.getCode());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto<AuthResponse>> registerUser(@RequestBody AuthRequest authRequest) {
        ResponseDto<AuthResponse> responseDto = new ResponseDto<>();

        try {
            if (Objects.nonNull(authValidator.validateRegister(authRequest))){
                responseDto.setCode(ResponseDtoCode.ERROR_VALIDATION.getCode());
                responseDto = authValidator.validateRegister(authRequest);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
            }

//            AuthResponse authResponse = authService.register(authRequest);

            responseDto.setCode(ResponseDtoCode.SUCCESS.getCode());
            responseDto.setMessage("Usuario registrado correctamente!");
//            responseDto.setResponse(authResponse);

            return ResponseEntity.status(HttpStatus.OK.value()).body(responseDto);
        } catch (Exception e) {
            responseDto.setCode(ResponseDtoCode.ERROR.getCode());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
        }
    }
}
