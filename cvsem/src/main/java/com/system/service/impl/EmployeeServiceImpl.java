package com.system.service.impl;

import com.system.mapper.employeeMapper;
import com.system.mapper.employeeMapperCustom;
import com.system.po.PagingVO;
import com.system.po.employee;
import com.system.po.employeeCustom;
import com.system.po.employeeExample;
import com.system.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private employeeMapper employeeMapper;

    @Autowired
    private employeeMapperCustom employeeMapperCustom;


    @Override
    public void updataById(Integer id, employee employee) throws Exception {
        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public void removeById(Integer id) throws Exception {
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<employeeCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<employeeCustom> list = employeeMapperCustom.findByPaging(pagingVO);

        return list;
    }

    @Override
    public Boolean save(employee employee) throws Exception {
        employee op = employeeMapper.selectByPrimaryKey(employee.getId());
        if (op == null) {
            employeeMapper.insert(employee);
            return true;
        }

        return false;
    }

    @Override
    public int getCountEmployee() throws Exception {
        //自定义查询对象
        employeeExample employeeExample = new employeeExample();
        //通过criteria构造查询条件
        employeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andIdIsNotNull();

        return employeeMapper.countByExample(employeeExample);
    }

    @Override
    public employee findById(Integer id) throws Exception {
        employee employee  = employeeMapper.selectByPrimaryKey(id);
        employee op = null;
        if (employee != null) {
            op = new employee();
            //类拷贝
            BeanUtils.copyProperties(employee, op);
        }

        return op;
    }

    @Override
    public List<employee> findByName(String name) throws Exception {
        employeeExample employeeExample = new employeeExample();
        //自定义查询条件
        employeeExample.Criteria criteria = employeeExample.createCriteria();

        criteria.andUsernameLike("%" + name + "%");

        List<employee> list = employeeMapper.selectByExample(employeeExample);

        return list;
    }
}
