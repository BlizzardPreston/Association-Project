package com.association.controller;

import com.association.College_project.service.UserService;
import com.association.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class logincontrollertest {
    @Autowired
    private UserService login;
    @GetMapping("testmapperlogin1/{id}/{pw}")
    public User getuserbylogin(@PathVariable("id") long id, @PathVariable("pw") String pw){
        return login.getuserbylogin(id,pw);
}
    @GetMapping("testmapperlogin2/{id}")
    public User getuserbyid(@PathVariable("id") long id){
        return login.getUserById(id);
    }
}
