package com.association.College_project.controller;

import com.association.College_project.service.ActivityService;
import com.association.College_project.shiro.ShiroUtils;
import com.association.common.Util.currentDate;
import com.association.common.entity.Activity;
import com.association.common.entity.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;
    //时间
    currentDate date=new currentDate();

    @RequestMapping("getActivityByClubID")
    @ResponseBody
    public Result getActivityByClubID(@RequestParam int clubID){
        return Result.success(activityService.getActivityByClubID(clubID));
    }

    @RequestMapping("WriteActivity")
    @ResponseBody
    public Result WriteActivity(@RequestParam String title,@RequestParam String text,@RequestParam String address,@RequestParam String activityTime,@RequestParam int clubID){
        Activity activity=new Activity(activityService.lastNumOfActivityID(),clubID,title,text,"",address,activityTime,date.getCurrentDate(),0);
        return  Result.success(activityService.WriteActivity(activity));
    }

    @RequestMapping("ActivityState")
    @ResponseBody
    public Result getActivityByState(@RequestParam int state){
        return Result.success(activityService.getActivityByState(state));
    }
    @RequestMapping("activityNum")
    @ResponseBody
    public Result activityNum(@RequestParam int state){
        return Result.success(activityService.activityNum(state));
    }

//    本地接口
    @RequestMapping("WriteActivitylocal")
    @ResponseBody
    public Result WriteActivitylocal(@RequestParam String title,@RequestParam String text,@RequestParam String address,@RequestParam String activityTime){
        Activity activity=new Activity(activityService.lastNumOfActivityID(), ShiroUtils.getCurrentUser().getClubID(),title,text,"",address,activityTime,date.getCurrentDate(),0);
        return  Result.success(activityService.WriteActivity(activity));
    }
}
