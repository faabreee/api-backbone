package com.joinify.backbone.application.repository;

import com.joinify.backbone.domain.entity.Usuario;

public interface IUserRepository {
    Usuario save(Usuario user);
    Usuario findByUsername(String username);
}
