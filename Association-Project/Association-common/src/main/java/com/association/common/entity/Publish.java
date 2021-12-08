package com.association.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("publish")
public class Publish implements Serializable {
    private int publishID;
    private long studentID;
    private String title;
    private String text;
    private String imgURL;
    //使用了java.sql.Date试试
    private LocalDateTime datetime;
    private int isSend;
    private long mycomID;
}
