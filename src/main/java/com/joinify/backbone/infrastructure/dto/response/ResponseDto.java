package com.joinify.backbone.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto<T> {
    private String code;
    private String message;
    private T response;
    @JsonIgnore
    private Integer status;

    public ResponseDto() {};

    public void errorAuth(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void errorGeneral(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
