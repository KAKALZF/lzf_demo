package com.ample16.backend.mapper;

import com.ample16.backend.entity.View;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(View record);

    int insertSelective(View record);

    View selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(View record);

    int updateByPrimaryKey(View record);
}