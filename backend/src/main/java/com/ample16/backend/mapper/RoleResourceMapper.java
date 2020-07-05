package com.ample16.backend.mapper;

import com.ample16.backend.entity.RoleResource;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleResourceMapper {
    int insert(RoleResource record);

    int insertSelective(RoleResource record);
}