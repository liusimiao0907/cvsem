package com.system.controller;

import com.system.exception.CustomException;
import com.system.po.PagingVO;
import com.system.po.volunteer;
import com.system.po.volunteerCustom;
import com.system.service.VolunteerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/volunteer")
public class VolunteerController {
    @Resource(name = "volunteerServiceImpl")
    private VolunteerService volunteerService;

    @RequestMapping("/showVolunteer")
    public String showVolunteer(Model model, Integer page) throws Exception {

        List<volunteerCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(volunteerService.getCountVolunteer());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = volunteerService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = volunteerService.findByPaging(page);
        }

        model.addAttribute("volunteerlist", list);
        model.addAttribute("pagingVO", pagingVO);

        return "volunteer/showVolunteer";
    }

    //  添加学生信息页面显示
    @RequestMapping(value = "/addVolunteer", method = {RequestMethod.GET})
    public String addStudentUI(Model model) throws Exception {
        return "volunteer/addVolunteer";
    }

    // 添加老人信息操作
    @RequestMapping(value = "/addVolunteer", method = {RequestMethod.POST})
    public String addVolunteer(volunteer volunteer, Model model) throws Exception {

        Boolean result = volunteerService.save(volunteer);

        if (!result) {
            model.addAttribute("message", "ID重复");
            return "error";
        }
        
        //重定向
        return "redirect:/volunteer/showVolunteer";
    }

    // 修改老人信息页面显示
    @RequestMapping(value = "/editVolunteer", method = {RequestMethod.GET})
    public String editVolunteerUI(Integer id, Model model) throws Exception {
        if (id == null) {
            return "redirect:/volunteer/showVolunteer";
        }
        volunteer volunteer = volunteerService.findById(id);
        if (volunteer == null) {
            throw new CustomException("未找到该老人");
        }

        model.addAttribute("volunteer", volunteer);
        
        return "volunteer/editVolunteer";
    }

    // 修改老人信息处理
    @RequestMapping(value = "/editVolunteer", method = {RequestMethod.POST})
    public String editVolunteer(volunteer volunteer) throws Exception {

        volunteerService.updataById(volunteer.getId(), volunteer);

        //重定向
        return "redirect:/volunteer/showVolunteer";
    }

    // 删除老人
    @RequestMapping(value = "/removeVolunteer", method = {RequestMethod.GET} )
    private String removeVolunteer(Integer id) throws Exception {
        if (id == null) {
            return "volunteer/showVolunteer";
        }
        volunteerService.removeById(id);

        return "redirect:/volunteer/showVolunteer";
    }

    // 搜索老人
    @RequestMapping(value = "/selectVolunteer", method = {RequestMethod.POST})
    private String selectVolunteer(String findByName, Model model) throws Exception {

        List<volunteer> list = volunteerService.findByName(findByName);

        model.addAttribute("volunteerlist", list);
        return "volunteer/showVolunteer";
    }
}
