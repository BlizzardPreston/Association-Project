package com.association.College_project.service;

import com.association.common.Dao.EmailDao;
import com.association.common.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailDao emailDao;

    public boolean WriteEmail(Email email){return emailDao.WriteEmail(email);}
    public long lastNumOfEmailID(){return emailDao.AllEmail().get(emailDao.AllEmail().size()-1).getEmailID()+1;}
    public List<Email> getEmailListByStudentIDto(long studentIDto){return emailDao.getEmailListByStudentIDto(studentIDto);}
}
