package com.joinify.backbone.infrastructure.repository;

import com.joinify.backbone.application.repository.IUserRepository;
import com.joinify.backbone.domain.entity.Usuario;
import com.joinify.backbone.infrastructure.entity.UserEntity;
import com.joinify.backbone.infrastructure.mapper.entity.IUserDboMapper;
import com.joinify.backbone.infrastructure.repository.jpa.IUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepository implements IUserRepository {
    private final IUserJpaRepository userJpaRepository;
    private final IUserDboMapper userDboMapper;

    @Override
    public Usuario save(Usuario user) {
        UserEntity userEntity = userDboMapper.toDbo(user);
        userEntity = userJpaRepository.saveAndFlush(userEntity);
        return userDboMapper.toDomain(userEntity);
    }

    @Override
    public Usuario findByUsername(String username) {
        UserEntity userEntity = userJpaRepository.findByUsername(username);
        return userDboMapper.toDomain(userEntity);
    }

}
