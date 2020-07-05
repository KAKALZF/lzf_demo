package com.ample16.backend.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_view
 * @author 
 */
@Data
public class View implements Serializable {
    private Long id;

    /**
     * 视图名称
     */
    private String name;

    /**
     * 视图路径
     */
    private String path;

    /**
     * 父节点id
     */
    private Long parentId;

    private static final long serialVersionUID = 1L;
}