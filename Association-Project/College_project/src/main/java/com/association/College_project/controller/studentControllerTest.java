package com.association.College_project.controller;

import com.association.College_project.service.StudentService;
import com.association.common.entity.Student;
import com.association.common.entity.common.Page;
import com.association.common.entity.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/student")
public class studentControllerTest {
    @Autowired
    private StudentService studentService;

    @RequestMapping("getnamebyid/{id}")
    @ResponseBody
    public String getStudentNameById(@PathVariable("id") long id) {
        return studentService.getStudentNameById(id);
    }

    @RequestMapping("getALLStudentlist")
    @ResponseBody
//    http://localhost:8888/student/getALLStudentlist?totalCount=0&pageNo=1&pageSize=3
    public List<Student> getAllStudent(Page page) {
        return studentService.getAllStudent(page);
    }

    @RequestMapping("register")
    @ResponseBody
    public Result doRegister() {

        return Result.success();
    }

    //测试redis
    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    @RequestMapping("redisset/{s}")
    @ResponseBody
    public String setRedis(@PathVariable("s") String s) {
        stringRedisTemplate.opsForValue().set("test", s, 60 * 2, TimeUnit.SECONDS);
        if (stringRedisTemplate.hasKey("test")) {
            return "ture";
        } else return "false";
    }

    @RequestMapping("redisget")
    @ResponseBody
    public String setRedis() {
        return stringRedisTemplate.opsForValue().get("test");
    }


}


