package com.system.service;

import com.system.po.user;

public interface UserService {

    //根据id查找用户
    user findById(int id) throws Exception;

    //根据名字查找用户
    user findByName(String name) throws Exception;

    //保存用户信息
    void save(user user) throws Exception;

    //根据名字更新用户信息
    void updateByName(String name, user user) throws Exception;
}
