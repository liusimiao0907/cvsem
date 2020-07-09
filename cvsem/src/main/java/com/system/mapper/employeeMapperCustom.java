package com.system.mapper;

import com.system.po.PagingVO;
import com.system.po.employeeCustom;

import java.util.List;

public interface employeeMapperCustom {
    //分页查询学生信息
    List<employeeCustom> findByPaging(PagingVO pagingVO) throws Exception;
}

