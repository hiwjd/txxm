package com.hiwjd.user;

import org.apache.ibatis.annotations.Insert;

public interface UserMapper {

  //@Insert("insert into user(un, password) values(#{un}, #{password})")
  void create(User user);
}
