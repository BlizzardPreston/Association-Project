package com.association.common.Dao;

import com.association.common.entity.Email;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailDao {
    boolean WriteEmail(@Param("email")Email email);
    List<Email> AllEmail();
    List<Email> getEmailListByStudentIDto(@Param("studentIDto")long studentIDto);
}
