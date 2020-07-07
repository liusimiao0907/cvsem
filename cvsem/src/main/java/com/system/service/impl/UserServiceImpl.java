package com.system.service.impl;

import com.system.mapper.userMapper;
import com.system.po.user;
import com.system.po.userExample;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private userMapper userMapper;
    @Override
    public user findById(int id) throws Exception {
        userExample userExample = new userExample();

        userExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);

        List<user> list = userMapper.selectByExample(userExample);

        return list.get(0);
    }

    @Override
    public user findByName(String name) throws Exception {
        userExample userExample = new userExample();

        userExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        List<user> list = userMapper.selectByExample(userExample);

        return list.get(0);
    }

    @Override
    public void save(user user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    public void updateByName(String name, user user) throws Exception {
        userExample userExample = new userExample();

        userExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userMapper.updateByExample(user, userExample);
    }
}
