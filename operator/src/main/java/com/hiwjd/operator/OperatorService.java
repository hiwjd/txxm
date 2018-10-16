package com.hiwjd.operator;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;

public class OperatorService {

  private final OperatorDAO operatorDAO;

  public OperatorService(SqlSessionFactory sqlSessionFactory) throws Exception {
    sqlSessionFactory.getConfiguration().addMapper(OperatorMapper.class);
    MapperFactoryBean mapperFactoryBean = new MapperFactoryBean();
    mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
    mapperFactoryBean.setMapperInterface(OperatorMapper.class);
    OperatorMapper operatorMapper = (OperatorMapper) mapperFactoryBean.getObject();
    operatorDAO = new OperatorDAO(operatorMapper);
  }

  public void create(Operator operator) {
    operatorDAO.create(operator);
  }
}
