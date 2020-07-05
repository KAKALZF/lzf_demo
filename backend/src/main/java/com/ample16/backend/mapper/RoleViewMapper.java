package com.ample16.backend.mapper;

import com.ample16.backend.entity.RoleView;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleViewMapper {
    int insert(RoleView record);

    int insertSelective(RoleView record);
}