package com.system.service;

import com.system.po.user;
import com.system.po.user;
import com.system.po.userCustom;

import java.util.List;

public interface UserService {

    //根据id查找用户
    user findById(int id) throws Exception;

    //根据名字查找用户
    user findByName(String name) throws Exception;

    //保存用户信息
    void save(user user) throws Exception;

    //根据名字更新用户信息
    void updateByName(String name, user user) throws Exception;

    //根据id更新老人信息
    void updataById(Integer id, user user) throws Exception;

    //根据id删除老人信息
    void removeById(Integer id) throws Exception;

    //获取分页查询老人信息
    List<userCustom> findByPaging(Integer toPageNo) throws Exception;

    //获取老人总数
    int getCountUser() throws Exception;

}
