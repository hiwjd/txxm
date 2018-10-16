package com.hiwjd.operator;

import lombok.Data;

import java.util.Date;

@Data
public class Operator {
    private Long uid;
    private Long cardealerId;
    private String un;
    private String mobile;
    private Date createdAt;
    private Date updatedAt;
}
