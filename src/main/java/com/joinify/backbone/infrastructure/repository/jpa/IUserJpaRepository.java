package com.joinify.backbone.infrastructure.repository.jpa;

import com.joinify.backbone.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJpaRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
