package com.association.common.Dao;

import com.association.common.entity.Recruit;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitDao {
    boolean isWriteRecruit(@Param("recruit")Recruit recruit);
    List<Recruit> AllRecruitID();
    Recruit getRecruitByID(@Param("recruitID")int rid);

    boolean deleteRecruitByRID(@Param("recruitID")int rid);


}
