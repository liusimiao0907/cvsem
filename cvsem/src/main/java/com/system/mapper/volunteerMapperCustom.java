package com.system.mapper;

import com.system.po.PagingVO;
import com.system.po.volunteerCustom;

import java.util.List;

public interface volunteerMapperCustom {
    //分页查询学生信息
    List<volunteerCustom> findByPaging(PagingVO pagingVO) throws Exception;
}

