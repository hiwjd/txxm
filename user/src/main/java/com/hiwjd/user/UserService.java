package com.hiwjd.user;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;

public class UserService {

  private final UserDAO userDAO;

  public UserService(SqlSessionFactory sqlSessionFactory) throws Exception {
    sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
    MapperFactoryBean mapperFactoryBean = new MapperFactoryBean();
    mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
    mapperFactoryBean.setMapperInterface(UserMapper.class);
    UserMapper userMapper = (UserMapper) mapperFactoryBean.getObject();
    userDAO = new UserDAO(userMapper);
  }

  public Long create(User user) {
    userDAO.create(user);
    return user.getUid();
  }
}
