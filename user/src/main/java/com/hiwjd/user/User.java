package com.hiwjd.user;

import lombok.Data;

import java.util.Date;

@Data
public class User {
  private Long uid;
  private String un;
  private String password;
  private Date createdAt;
  private Date updatedAt;
}
