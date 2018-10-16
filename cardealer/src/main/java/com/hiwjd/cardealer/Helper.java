package com.hiwjd.cardealer;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;

import javax.sql.DataSource;

public class Helper {
    static SqlSessionFactory buildSqlSessionFactory(DataSource dataSource) {
        SpringManagedTransactionFactory transactionFactory = new SpringManagedTransactionFactory();

        Environment environment = new Environment("default", transactionFactory, dataSource);

        Configuration configuration = new Configuration(environment);
        configuration.setLazyLoadingEnabled(true);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.addMapper(CardealerMapper.class);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(configuration);

        return factory;
    }
}
