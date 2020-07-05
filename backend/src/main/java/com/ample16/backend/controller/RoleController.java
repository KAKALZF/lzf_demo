package com.ample16.backend.controller;

import com.ample16.backend.entity.User;
import com.ample16.backend.mapper.UserMapper;
import com.ample16.backend.resp.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/list")
    public ResponseBean<List<User>> list() {
        User user = userMapper.selectByPrimaryKey(1L);
        ArrayList<User> users = new ArrayList<>();
        return ResponseBean.success().setData(user);
    }
}
