package com.hiwjd.user;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

public class Helper {
  static SqlSessionFactory buildSqlSessionFactory(DataSource dataSource) {
    //TransactionFactory transactionFactory = new JdbcTransactionFactory();

    //Environment environment = new Environment("default", transactionFactory, dataSource);

    Configuration configuration = new Configuration();
    configuration.setLazyLoadingEnabled(true);
    configuration.setMapUnderscoreToCamelCase(true);
    configuration.addMapper(UserMapper.class);

    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(configuration);

    return factory;
  }
}
