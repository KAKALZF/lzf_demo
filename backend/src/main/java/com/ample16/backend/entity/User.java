package com.ample16.backend.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_user
 * @author
 */
@Data
public class User implements Serializable {
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否是管理员:0-不是;1-是
     */
    private Boolean isAdmin;

    /**
     * 盐值
     */
    private String salt;

    private static final long serialVersionUID = 1L;

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}