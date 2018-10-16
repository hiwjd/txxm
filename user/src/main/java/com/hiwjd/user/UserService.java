package com.hiwjd.user;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

import javax.sql.DataSource;

public class UserService {

    private final UserDAO userDAO;

    public UserService(DataSource dataSource) {
        SqlSessionFactory sqlSessionFactory = Helper.buildSqlSessionFactory(dataSource);
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
        userDAO = new UserDAO(userMapper);
    }

    public Long create(User user) {
        userDAO.create(user);
        return user.getUid();
    }
}
