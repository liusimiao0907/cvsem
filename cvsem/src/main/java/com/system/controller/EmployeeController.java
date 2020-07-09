package com.system.controller;

import com.system.exception.CustomException;
import com.system.po.PagingVO;
import com.system.po.employee;
import com.system.po.employeeCustom;
import com.system.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;

    @RequestMapping("/showEmployee")
    public String showEmployee(Model model, Integer page) throws Exception {

        List<employeeCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(employeeService.getCountEmployee());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = employeeService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = employeeService.findByPaging(page);
        }

        model.addAttribute("employeelist", list);
        model.addAttribute("pagingVO", pagingVO);

        return "employee/showEmployee";
    }

    //  添加学生信息页面显示
    @RequestMapping(value = "/addEmployee", method = {RequestMethod.GET})
    public String addStudentUI(Model model) throws Exception {
        return "employee/addEmployee";
    }

    // 添加老人信息操作
    @RequestMapping(value = "/addEmployee", method = {RequestMethod.POST})
    public String addEmployee(employee employee, Model model) throws Exception {

        Boolean result = employeeService.save(employee);

        if (!result) {
            model.addAttribute("message", "ID重复");
            return "error";
        }
        
        //重定向
        return "redirect:/employee/showEmployee";
    }

    // 修改老人信息页面显示
    @RequestMapping(value = "/editEmployee", method = {RequestMethod.GET})
    public String editEmployeeUI(Integer id, Model model) throws Exception {
        if (id == null) {
            return "redirect:/employee/showEmployee";
        }
        employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new CustomException("未找到该老人");
        }

        model.addAttribute("employee", employee);
        
        return "employee/editEmployee";
    }

    // 修改老人信息处理
    @RequestMapping(value = "/editEmployee", method = {RequestMethod.POST})
    public String editEmployee(employee employee) throws Exception {

        employeeService.updataById(employee.getId(), employee);

        //重定向
        return "redirect:/employee/showEmployee";
    }

    // 删除老人
    @RequestMapping(value = "/removeEmployee", method = {RequestMethod.GET} )
    private String removeEmployee(Integer id) throws Exception {
        if (id == null) {
            return "employee/showEmployee";
        }
        employeeService.removeById(id);

        return "redirect:/employee/showEmployee";
    }

    // 搜索老人
    @RequestMapping(value = "/selectEmployee", method = {RequestMethod.POST})
    private String selectEmployee(String findByName, Model model) throws Exception {

        List<employee> list = employeeService.findByName(findByName);

        model.addAttribute("employeelist", list);
        return "employee/showEmployee";
    }
}
