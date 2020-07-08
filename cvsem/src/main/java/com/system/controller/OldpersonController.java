package com.system.controller;

import com.system.exception.CustomException;
import com.system.po.PagingVO;
import com.system.po.oldperson;
import com.system.po.oldpersonCustom;
import com.system.service.OldpersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/oldperson")
public class OldpersonController {
    @Resource(name = "oldpersonServiceImpl")
    private OldpersonService oldpersonService;

    @RequestMapping("/showOldperson")
    public String showOldperson(Model model, Integer page) throws Exception {

        List<oldpersonCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(oldpersonService.getCountOldperson());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = oldpersonService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = oldpersonService.findByPaging(page);
        }

        model.addAttribute("oldpersonlist", list);
        model.addAttribute("pagingVO", pagingVO);

        return "oldperson/showOldperson";
    }

    //  添加学生信息页面显示
    @RequestMapping(value = "/addOldperson", method = {RequestMethod.GET})
    public String addStudentUI(Model model) throws Exception {
        return "oldperson/addOldperson";
    }

    // 添加老人信息操作
    @RequestMapping(value = "/addOldperson", method = {RequestMethod.POST})
    public String addOldperson(oldperson oldperson, Model model) throws Exception {

        Boolean result = oldpersonService.save(oldperson);

        if (!result) {
            model.addAttribute("message", "ID重复");
            return "error";
        }
        
        //重定向
        return "redirect:/oldperson/showOldperson";
    }

    // 修改老人信息页面显示
    @RequestMapping(value = "/editOldperson", method = {RequestMethod.GET})
    public String editOldpersonUI(Integer id, Model model) throws Exception {
        if (id == null) {
            return "redirect:/oldperson/showOldperson";
        }
        oldperson oldperson = oldpersonService.findById(id);
        if (oldperson == null) {
            throw new CustomException("未找到该老人");
        }

        model.addAttribute("oldperson", oldperson);
        
        return "oldperson/editOldperson";
    }

    // 修改老人信息处理
    @RequestMapping(value = "/editOldperson", method = {RequestMethod.POST})
    public String editOldperson(oldperson oldperson) throws Exception {

        oldpersonService.updataById(oldperson.getId(), oldperson);

        //重定向
        return "redirect:/oldperson/showOldperson";
    }

    // 删除老人
    @RequestMapping(value = "/removeOldperson", method = {RequestMethod.GET} )
    private String removeOldperson(Integer id) throws Exception {
        if (id == null) {
            return "oldperson/showOldperson";
        }
        oldpersonService.removeById(id);

        return "redirect:/oldperson/showOldperson";
    }

    // 搜索老人
    @RequestMapping(value = "/selectOldperson", method = {RequestMethod.POST})
    private String selectOldperson(String findByName, Model model) throws Exception {

        List<oldperson> list = oldpersonService.findByName(findByName);

        model.addAttribute("oldpersonlist", list);
        return "oldperson/showOldperson";
    }
}
