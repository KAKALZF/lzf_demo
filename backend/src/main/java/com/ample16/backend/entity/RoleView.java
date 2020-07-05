package com.ample16.backend.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * role_view
 * @author 
 */
@Data
public class RoleView implements Serializable {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 视图id
     */
    private Long viewId;

    private static final long serialVersionUID = 1L;
}