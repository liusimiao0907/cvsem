package com.system.service;

import com.system.po.employee;
import com.system.po.employeeCustom;

import java.util.List;

public interface EmployeeService {
    //根据id更新老人信息
    void updataById(Integer id, employee employee) throws Exception;

    //根据id删除老人信息
    void removeById(Integer id) throws Exception;

    //获取分页查询老人信息
    List<employeeCustom> findByPaging(Integer toPageNo) throws Exception;

    //保存老人信息
    Boolean save(employee employee) throws Exception;

    //获取老人总数
    int getCountEmployee() throws Exception;

    //根据id获取老人信息
    employee findById(Integer id) throws Exception;

    //根据名字模糊查询
    List<employee> findByName(String name) throws Exception;
}

