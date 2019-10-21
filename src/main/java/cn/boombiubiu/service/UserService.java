package cn.boombiubiu.service;

import cn.boombiubiu.model.domain.User;

import java.util.List;

public interface UserService {

    List<User> userList();

    User queryUserById(String id);
}
