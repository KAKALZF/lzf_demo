package com.ample16.backend.controller;

import com.ample16.backend.entity.AuthScope;
import com.ample16.backend.entity.Resource;
import com.ample16.backend.entity.User;
import com.ample16.backend.mapper.ResourceMapper;
import com.ample16.backend.resp.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resource")
public class ResoucerController {
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    ResourceMapper resourceMapper;

    @GetMapping("/list")
    @AuthScope("资源列表")
    public ResponseBean<HashMap> list() {
        HashMap<String, Object> map = new HashMap<>();
        List<Resource> list = resourceMapper.list();
        map.put("list", list);
        map.put("total", list.size());
        return ResponseBean.success().setData(map);
    }

    @GetMapping("/reload")
    @AuthScope("重新加载资源")
    public ResponseBean<List<Resource>> reload() {
        ArrayList<Resource> resources = new ArrayList<>();
        //获取所有的RestController
        Map<String, Object> controllerMap = applicationContext.getBeansWithAnnotation(RestController.class);
        for (String controllerName : controllerMap.keySet()) {
            System.out.println(controllerName + ":" + controllerMap.get(controllerName).getClass().getName());
            Method[] methods = controllerMap.get(controllerName).getClass().getMethods();
            for (Method method : methods) {
                AuthScope annotation = method.getAnnotation(AuthScope.class);
                if (annotation != null) {
                    System.out.println(annotation.value());
                    Resource resource = new Resource();
                    resource.setName(controllerMap.get(controllerName).getClass().getName() + "|" + method.getName());
                    resource.setDesc(annotation.value());
                    resources.add(resource);
                }
            }
        }
        resources.stream().forEach(
                resource -> {
                    resourceMapper.insert(resource);
                }
        );
        return ResponseBean.success().setData(resources);
    }
}
