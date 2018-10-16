package com.hiwjd.user;

public class UserDAO {
  private final UserMapper userMapper;

  public UserDAO(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public void create(User user) {
    userMapper.create(user);
  }
}
