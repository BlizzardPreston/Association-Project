package com.association.common.Dao;

import com.association.common.entity.Publish;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublishDao {
    Publish getPublishByID(@Param("publishID")long pid);
    boolean WritePublish(@Param("publish") Publish publish);
    List<Publish> AllPublish();
    List<Publish> AllPublishByStudentID(@Param("studentID")long studentID);
    boolean deleteByPublishId(@Param("publishID")int pid);
}
