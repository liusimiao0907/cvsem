package com.system.mapper;

import com.system.po.PagingVO;
import com.system.po.userCustom;

import java.util.List;

public interface userMapperCustom {
    //分页查询学生信息
    List<userCustom> findByPaging(PagingVO pagingVO) throws Exception;
}

