package com.association.common.Dao;

import com.association.common.entity.Student;
import com.association.common.entity.common.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    Student getStudentByid(@Param("studentID") long id);
    //    查询所有学生信息
    List<Student> getAllStudent(@Param("page") Page page);

    Student getStudentById(long id);

    Student getStudentByName(String name);

    Student getStudentByGrade(int grade);

    String getsStudentNameById(long id);

    boolean is2017(@Param("studentID") long id);
    boolean addStudent(Student student);
    boolean deleteById(@Param("studentID")long id);
    List<Student> getStudentListByClubID(@Param("clubID")int id);
    boolean updataStudentClubID(@Param("studentID") long id,@Param("studentName") String name,@Param("clubID")int cid);
    boolean addClubMenber(@Param("studentID") long id,@Param("studentName")String name,@Param("work") String work,@Param("clubID") int cid);
    int getClubIDByStudentID(@Param("studentID")long sid);
}
