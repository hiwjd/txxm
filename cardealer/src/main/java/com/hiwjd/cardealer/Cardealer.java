package com.hiwjd.cardealer;

import lombok.Data;

import java.util.Date;

@Data
public class Cardealer {
  private Long id;
  private String name;
  private Date createdAt;
  private Date updatedAt;
}
