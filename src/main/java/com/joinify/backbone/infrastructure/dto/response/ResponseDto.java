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
}
