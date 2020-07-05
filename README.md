# 前后端分离项目demo
前后端分离demo,整合日常开发所需用到的业务点的实现
##v1.1版本(2020-06-13 - 2020-06-14)

1.参考:

 书籍:开涛的<<跟我学shiro>>
 
 [springboot整合shiro（完整版）](https://www.jianshu.com/p/7f724bec3dc3)
 
 [springboot与shiro整合(示例)](https://blog.csdn.net/u014203449/article/details/79330811)

2.功能点:

springboot整合shiro;
实现用户的用户认证和授权

3:
登录请求:(localhost:8080/test/login)

| 接口名称 | 请求地址 | 作用 |
|:----:|:----:|:----:|
| 登录请求 | http://localhost:8080/test/login | 传入账号密码登录 |
| 登出 | http://llocalhost:8080/test/logout | 用户退出 |
| 加载权限列表 | http://llocalhost:8080/test/loadPermission | 获取权限列表 |
