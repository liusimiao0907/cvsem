package com.system.controller;

import com.system.exception.CustomException;
import com.system.po.PagingVO;
import com.system.po.user;
import com.system.po.userCustom;
import com.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(Model model, Integer page) throws Exception {

        List<userCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(userService.getCountUser());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = userService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = userService.findByPaging(page);
        }

        model.addAttribute("userlist", list);
        model.addAttribute("pagingVO", pagingVO);

        return "user/showUser";
    }

    //  添加学生信息页面显示
    @RequestMapping(value = "/addUser", method = {RequestMethod.GET})
    public String addStudentUI(Model model) throws Exception {
        return "user/addUser";
    }

    // 添加老人信息操作
    @RequestMapping(value = "/addUser", method = {RequestMethod.POST})
    public String addUser(user user, Model model) throws Exception {

        userService.save(user);

        //重定向
        return "redirect:/user/showUser";
    }

    // 修改老人信息页面显示
    @RequestMapping(value = "/editUser", method = {RequestMethod.GET})
    public String editUserUI(Integer id, Model model) throws Exception {
        if (id == null) {
            return "redirect:/user/showUser";
        }
        user user = userService.findById(id);
        if (user == null) {
            throw new CustomException("未找到该老人");
        }

        model.addAttribute("user", user);

        return "user/editUser";
    }

    // 修改老人信息处理
    @RequestMapping(value = "/editUser", method = {RequestMethod.POST})
    public String editUser(user user) throws Exception {

        userService.updataById(user.getId(), user);

        //重定向
        return "redirect:/user/showUser";
    }

    // 删除老人
    @RequestMapping(value = "/removeUser", method = {RequestMethod.GET} )
    private String removeUser(Integer id) throws Exception {
        if (id == null) {
            return "user/showUser";
        }
        userService.removeById(id);

        return "redirect:/user/showUser";
    }
}
