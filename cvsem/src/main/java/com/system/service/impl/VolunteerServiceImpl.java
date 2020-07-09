package com.system.service.impl;

import com.system.mapper.volunteerMapper;
import com.system.mapper.volunteerMapperCustom;
import com.system.po.PagingVO;
import com.system.po.volunteer;
import com.system.po.volunteerCustom;
import com.system.po.volunteerExample;
import com.system.service.VolunteerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    private volunteerMapper volunteerMapper;

    @Autowired
    private volunteerMapperCustom volunteerMapperCustom;


    @Override
    public void updataById(Integer id, volunteer volunteer) throws Exception {
        volunteerMapper.updateByPrimaryKey(volunteer);
    }

    @Override
    public void removeById(Integer id) throws Exception {
        volunteerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<volunteerCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<volunteerCustom> list = volunteerMapperCustom.findByPaging(pagingVO);

        return list;
    }

    @Override
    public Boolean save(volunteer volunteer) throws Exception {
        volunteer op = volunteerMapper.selectByPrimaryKey(volunteer.getId());
        if (op == null) {
            volunteerMapper.insert(volunteer);
            return true;
        }

        return false;
    }

    @Override
    public int getCountVolunteer() throws Exception {
        //自定义查询对象
        volunteerExample volunteerExample = new volunteerExample();
        //通过criteria构造查询条件
        volunteerExample.Criteria criteria = volunteerExample.createCriteria();
        criteria.andIdIsNotNull();

        return volunteerMapper.countByExample(volunteerExample);
    }

    @Override
    public volunteer findById(Integer id) throws Exception {
        volunteer volunteer  = volunteerMapper.selectByPrimaryKey(id);
        volunteer op = null;
        if (volunteer != null) {
            op = new volunteer();
            //类拷贝
            BeanUtils.copyProperties(volunteer, op);
        }

        return op;
    }

    @Override
    public List<volunteer> findByName(String name) throws Exception {
        volunteerExample volunteerExample = new volunteerExample();
        //自定义查询条件
        volunteerExample.Criteria criteria = volunteerExample.createCriteria();

        criteria.andNameLike("%" + name + "%");

        List<volunteer> list = volunteerMapper.selectByExample(volunteerExample);

        return list;
    }
}
