package com.dlh.thymeleaf.controller;

import com.dlh.thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author wutao
 * @date 2019/11/25
 */
@Controller
public class ThymeleafController {

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show(Model model){
        model.addAttribute("uid","123456789");
        model.addAttribute("name","Jerry");
        return "show";
    }

    @RequestMapping(value = "showStyle", method = RequestMethod.GET)
    public String showStyle(Model model){
        model.addAttribute("uid","123456789");
        model.addAttribute("name","<span style='color:red'>Jerry</span>");
        return "show_style";
    }

    @RequestMapping(value = "/message/member_show", method = RequestMethod.GET)
    public String memberShow(Model model) {
        User vo = new User();
        vo.setUid(12345678L);
        vo.setName("尼古拉丁.赵四");
        vo.setAge(59);
        vo.setSalary(1000.00);
        vo.setBirthday(new Date());
        model.addAttribute("member", vo);
        return "message/member_show";
    }

    @RequestMapping(value = "/user/set", method = RequestMethod.GET)
    public String set(Model model) {
        Set<String> allNames = new HashSet<String>() ;
        List<Integer> allIds = new ArrayList<Integer>() ;
        for (int x = 0 ; x < 5 ; x ++) {
            allNames.add("boot-" + x) ;
            allIds.add(x) ;
        }
        model.addAttribute("names", allNames) ;
        model.addAttribute("ids", allIds) ;
        model.addAttribute("mydate", new java.util.Date()) ;
        return "user_set" ;
    }

    @RequestMapping(value = "/inner", method = RequestMethod.GET)
    public String inner(HttpServletRequest request, Model model) {
        request.setAttribute("requestMessage", "springboot-request");
        request.getSession().setAttribute("sessionMessage", "springboot-session");
        request.getServletContext().setAttribute("applicationMessage",
                "springboot-application");
        model.addAttribute("url", "www.baidu.cn");
        request.setAttribute("url2",
                "<span style='color:red'>www.baidu.cn</span>");
        return "show_inner";
    }
}
