package com.association.College_project.service;

import com.association.common.Dao.ClubDao;
import com.association.common.Dao.StudentDao;
import com.association.common.Dao.UserDao;
import com.association.common.entity.Student;
import com.association.common.entity.common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ClubDao clubDao;
    @Autowired
    private UserDao userDao;

    public String getStudentNameById(long id){
        System.out.println("StudentService------->>>getStudentName");
        return studentDao.getStudentByid(id).getStudentName();
    }
    public List<Student> getAllStudent(Page page){
        return studentDao.getAllStudent(page);
    }
    public boolean addStudent(Student student){
    if (studentDao.addStudent(student)){
        System.out.println("添加student成功!");
        return true;
    }else {
        System.out.println("添加student失败！");
        return false;
    }
    }
    public boolean deleteById(long id){
        if(studentDao.deleteById(id)){
            System.out.println("成功删除此学生: "+id);
            return true;
        }else return false;
    }
//    把学生从社团删除，相当于把学生表的clubID改为0
    public boolean deleteClubByID(long id){
        if(studentDao.updataStudentClubID(id,studentDao.getsStudentNameById(id),0)){
            return true;
        }else return false;

    }
    public boolean addClubMenber(long id,String name ,String work,int cid){
        if(studentDao.addClubMenber(id,name,work,cid)){
            clubDao.updataClubNum(cid,studentDao.getStudentListByClubID(cid).size());
            return true;
        }else return false;
    }
    public int getClubIDByStudentID(long sid){
        return studentDao.getClubIDByStudentID(sid);
    }
    public Student getStudentById(long id){
        return studentDao.getStudentById(id);
    }
    public boolean updateUserClubID(long studentID,int clubID,int auth){return userDao.updataClubID(clubID,studentID,auth);}
    public List<Student> getStudentListByClubID(int cid){return studentDao.getStudentListByClubID(cid);}
}
