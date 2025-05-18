package com.joinify.backbone.infrastructure.validator;

import com.joinify.backbone.application.service.UserDetailsServiceImpl;
import com.joinify.backbone.domain.valueobject.ResponseDtoCode;
import com.joinify.backbone.infrastructure.dto.request.AuthRequest;
import com.joinify.backbone.infrastructure.dto.response.AuthResponse;
import com.joinify.backbone.infrastructure.dto.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthValidator {
    private final UserDetailsServiceImpl userDetailsService;

    public ResponseDto<AuthResponse> validateRegister(AuthRequest authRequest) {
        ResponseDto<AuthResponse> responseDto = new ResponseDto<>();

        try {
            if (userDetailsService.validateExistenceUser(authRequest.getUsername())) {
                responseDto.setMessage("El nombre de usuario ya existe");
                return responseDto;
            }
        } catch (Exception ex) {
            responseDto.setCode(ResponseDtoCode.ERROR.getCode());
            return responseDto;
        }
        return null;
    }

}
