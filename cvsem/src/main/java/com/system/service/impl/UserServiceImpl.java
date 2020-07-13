package com.system.service.impl;

import com.system.mapper.userMapper;
import com.system.mapper.userMapperCustom;
import com.system.mapper.volunteerMapperCustom;
import com.system.po.PagingVO;
import com.system.po.user;
import com.system.po.userCustom;
import com.system.po.userExample;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private userMapper userMapper;

    @Autowired
    private userMapperCustom userMapperCustom;

    @Override
    public user findById(int id) throws Exception {
        userExample userExample = new userExample();

        userExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);

        List<user> list = userMapper.selectByExample(userExample);

        return list.get(0);
    }

    @Override
    public user findByName(String name) throws Exception {
        userExample userExample = new userExample();

        userExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        List<user> list = userMapper.selectByExample(userExample);

        return list.get(0);
    }

    @Override
    public void save(user user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    public void updateByName(String name, user user) throws Exception {
        userExample userExample = new userExample();

        userExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userMapper.updateByExample(user, userExample);
    }



    @Override
    public void updataById(Integer id, user user) throws Exception {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void removeById(Integer id) throws Exception {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<userCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<userCustom> list = userMapperCustom.findByPaging(pagingVO);

        return list;
    }

    @Override
    public int getCountUser() throws Exception {
        //自定义查询对象
        userExample userExample = new userExample();
        //通过criteria构造查询条件
        userExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdIsNotNull();

        return userMapper.countByExample(userExample);
    }

}
