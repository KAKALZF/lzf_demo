package com.ample16.backend.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_role
 * @author 
 */
@Data
public class Role implements Serializable {
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String describe;

    private static final long serialVersionUID = 1L;
}