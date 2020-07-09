package com.system.service;

import com.system.po.volunteer;
import com.system.po.volunteerCustom;

import java.util.List;

public interface VolunteerService {
    //根据id更新老人信息
    void updataById(Integer id, volunteer volunteer) throws Exception;

    //根据id删除老人信息
    void removeById(Integer id) throws Exception;

    //获取分页查询老人信息
    List<volunteerCustom> findByPaging(Integer toPageNo) throws Exception;

    //保存老人信息
    Boolean save(volunteer volunteer) throws Exception;

    //获取老人总数
    int getCountVolunteer() throws Exception;

    //根据id获取老人信息
    volunteer findById(Integer id) throws Exception;

    //根据名字模糊查询
    List<volunteer> findByName(String name) throws Exception;
}

