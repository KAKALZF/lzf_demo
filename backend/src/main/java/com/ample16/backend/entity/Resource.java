package com.ample16.backend.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_resource
 * @author 
 */
@Data
public class Resource implements Serializable {
    private Long id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源描述
     */
    private String desc;

    private static final long serialVersionUID = 1L;
}