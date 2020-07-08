package com.system.mapper;

import com.system.po.PagingVO;
import com.system.po.oldpersonCustom;

import java.util.List;

public interface oldpersonMapperCustom {
    //分页查询学生信息
    List<oldpersonCustom> findByPaging(PagingVO pagingVO) throws Exception;
}

