package com.system.service;

import com.system.po.oldperson;
import com.system.po.oldpersonCustom;

import java.util.List;

public interface OldpersonService {
    //根据id更新老人信息
    void updataById(Integer id, oldperson oldperson) throws Exception;

    //根据id删除老人信息
    void removeById(Integer id) throws Exception;

    //获取分页查询老人信息
    List<oldpersonCustom> findByPaging(Integer toPageNo) throws Exception;

    //保存老人信息
    Boolean save(oldperson oldperson) throws Exception;

    //获取老人总数
    int getCountOldperson() throws Exception;

    //根据id获取老人信息
    oldperson findById(Integer id) throws Exception;

    //根据名字模糊查询
    List<oldperson> findByName(String name) throws Exception;
}

