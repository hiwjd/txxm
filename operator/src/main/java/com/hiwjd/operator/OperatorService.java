package com.hiwjd.operator;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

import javax.sql.DataSource;

public class OperatorService {

    private final OperatorDAO operatorDAO;

    public OperatorService(DataSource dataSource) {
        SqlSessionFactory sqlSessionFactory = Helper.buildSqlSessionFactory(dataSource);
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        OperatorMapper operatorMapper = sqlSessionTemplate.getMapper(OperatorMapper.class);
        operatorDAO = new OperatorDAO(operatorMapper);
    }

    public void create(Operator operator) {
        operatorDAO.create(operator);
    }
}
