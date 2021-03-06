package com.association.College_project.controller;


import com.association.College_project.service.StudentService;
import com.association.College_project.service.UserService;
import com.association.College_project.shiro.ShiroUtils;
import com.association.common.entity.User;
import com.association.common.entity.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(value = "/Index")
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getUsername",method = RequestMethod.GET)
    public String getUserName(){
        User user = ShiroUtils.getCurrentUser();
        return userService.getUserById(user.getStudentID()).getUserName();
    }

    @RequestMapping(value = "/getUsername2",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Result getUserName2(@RequestParam String id,@RequestParam String name){

//        return userService.getUserById(Double.valueOf(id)).getUserName();
        System.out.println(".............执行getUserName2........");
        System.out.println(name);
        return Result.success(userService.getUserById(Long.valueOf(id)));
    }
    @RequestMapping(value = "/getAuthName",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String getAuthName(){
//        long id=17251106111l;
//        System.out.println("执行了---->>IndexController类的 <getAuthID> 方法");
//        System.out.println("返回userName为： "+ShiroUtils.getCurrentUser().getUserName());
        return ShiroUtils.getCurrentUser().getUserName();
    }
    @RequestMapping("getAuth")
    @ResponseBody
    public Result getAuth(){
        return Result.success(studentService.getStudentById(ShiroUtils.getCurrentUser().getStudentID()));
    }



}
