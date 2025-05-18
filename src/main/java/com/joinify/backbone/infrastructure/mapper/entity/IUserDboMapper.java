package com.joinify.backbone.infrastructure.mapper.entity;

import com.joinify.backbone.domain.entity.Usuario;
import com.joinify.backbone.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserDboMapper {
    Usuario toDomain(UserEntity userEntity);
    UserEntity toDbo(Usuario user);
}
