package com.ample16.backend.controller;

import com.ample16.backend.entity.User;
import com.ample16.backend.mapper.UserMapper;
import com.ample16.backend.resp.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/list")
    public ResponseBean<HashMap> list() {
        HashMap<String, Object> map = new HashMap<>();
        List<User> list = userMapper.list();
        map.put("list", list);
        map.put("total", list.size());
        return ResponseBean.success().setData(map);
    }

    @PostMapping("/saveOrUpdate")
    public ResponseBean saveOrUpdate(@RequestBody User user) {
        Long id = user.getId();
        user.setSalt("testSalt");
        if (null == id) {
            userMapper.insert(user);
        } else {
            userMapper.updateByPrimaryKey(user);
        }
        return ResponseBean.success();
    }


}
