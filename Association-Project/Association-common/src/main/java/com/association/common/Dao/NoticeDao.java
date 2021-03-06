package com.association.common.Dao;

import com.association.common.entity.Notice;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDao {
    boolean WriteNotice(@Param("notice")Notice notice);
    List<Notice> AllNotice();
    Notice getNoticeByClubID(@Param("clubID") int cid);
    boolean deleteNoticeByNoticeID(@Param("noticeID")long nid);
    List<Notice> getNoticListByClubID(@Param("clubID")int cid);
}
