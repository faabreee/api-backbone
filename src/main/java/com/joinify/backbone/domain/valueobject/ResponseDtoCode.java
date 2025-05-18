package com.joinify.backbone.domain.valueobject;

import lombok.Getter;

@Getter
public enum ResponseDtoCode {
    SUCCESS("00"),
    ERROR("01"),
    ERROR_VALIDATION("02");

    private final String code;

    ResponseDtoCode(String code) { this.code = code; }
}
