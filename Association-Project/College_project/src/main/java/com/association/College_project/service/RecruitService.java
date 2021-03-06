package com.association.College_project.service;

import com.association.common.Dao.RecruitDao;
import com.association.common.entity.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitService {
    @Autowired
    private RecruitDao recruitDao;

    public boolean isWriteRecruit(Recruit recruit){
        return recruitDao.isWriteRecruit(recruit);
    }
    public int numOfRecruit(){
        //获得评论数量
        return recruitDao.AllRecruitID().size();
    }
    //获得最后一条评论的id号
    public int lastNumOfRecruit(){return recruitDao.AllRecruitID().get(recruitDao.AllRecruitID().size()-1).getRecruitID()+1;}
    public Recruit getRecruitByID(int rid){return recruitDao.getRecruitByID(rid);}
    public boolean deleteRecruitByRID(int rid){return recruitDao.deleteRecruitByRID(rid);}
    public List<Recruit> AllRecruitID(){
        return recruitDao.AllRecruitID();
    }
}
