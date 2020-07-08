package com.system.service.impl;

import com.system.mapper.oldpersonMapper;
import com.system.mapper.oldpersonMapperCustom;
import com.system.po.PagingVO;
import com.system.po.oldperson;
import com.system.po.oldpersonCustom;
import com.system.po.oldpersonExample;
import com.system.service.OldpersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OldpersonServiceImpl implements OldpersonService {
    @Autowired
    private oldpersonMapper oldpersonMapper;

    @Autowired
    private oldpersonMapperCustom oldpersonMapperCustom;


    @Override
    public void updataById(Integer id, oldperson oldperson) throws Exception {
        oldpersonMapper.updateByPrimaryKey(oldperson);
    }

    @Override
    public void removeById(Integer id) throws Exception {
        oldpersonMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<oldpersonCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<oldpersonCustom> list = oldpersonMapperCustom.findByPaging(pagingVO);

        return list;
    }

    @Override
    public Boolean save(oldperson oldperson) throws Exception {
        oldperson op = oldpersonMapper.selectByPrimaryKey(oldperson.getId());
        if (op == null) {
            oldpersonMapper.insert(oldperson);
            return true;
        }

        return false;
    }

    @Override
    public int getCountOldperson() throws Exception {
        //自定义查询对象
        oldpersonExample oldpersonExample = new oldpersonExample();
        //通过criteria构造查询条件
        oldpersonExample.Criteria criteria = oldpersonExample.createCriteria();
        criteria.andIdIsNotNull();

        return oldpersonMapper.countByExample(oldpersonExample);
    }

    @Override
    public oldperson findById(Integer id) throws Exception {
        oldperson oldperson  = oldpersonMapper.selectByPrimaryKey(id);
        oldperson op = null;
        if (oldperson != null) {
            op = new oldperson();
            //类拷贝
            BeanUtils.copyProperties(oldperson, op);
        }

        return op;
    }

    @Override
    public List<oldperson> findByName(String name) throws Exception {
        oldpersonExample oldpersonExample = new oldpersonExample();
        //自定义查询条件
        oldpersonExample.Criteria criteria = oldpersonExample.createCriteria();

        criteria.andUsernameLike("%" + name + "%");

        List<oldperson> list = oldpersonMapper.selectByExample(oldpersonExample);

        return list;
    }
}
