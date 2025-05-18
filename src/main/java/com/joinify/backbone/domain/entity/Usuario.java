package com.joinify.backbone.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private Integer id;
    private String uuid;
    private String username;
    private String password;
}
