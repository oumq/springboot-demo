package cn.boombiubiu.service.impl;

import cn.boombiubiu.mapper.UserMapper;
import cn.boombiubiu.model.domain.User;
import cn.boombiubiu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> userList() {
        return userMapper.selectList(null);
    }

    @Override
    public User queryUserById(String id) {
        return userMapper.selectById(id);
    }


}
