package com.hiwjd.app.conf;

import com.hiwjd.bal.BalService;
import com.hiwjd.operator.OperatorService;
import com.hiwjd.user.UserService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class Config {

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return new org.apache.tomcat.jdbc.pool.DataSource();
  }

  @Bean
  @Qualifier("dsAwareTx")
  @Autowired
  public DataSource dataSourceAwareTransaction(DataSource dataSource) {
    return new TransactionAwareDataSourceProxy(dataSource);
  }

  @Bean
  public DataSourceTransactionManager transactionManager(DataSource dataSource) {
    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
    transactionManager.setDataSource(dataSource);
    return transactionManager;
  }

  @Bean
  public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);

//    Resource[] resources = new Resource[2];
//    resources[0] = new ClassPathResource("classpath:com/hiwjd/operator/OperatorMapper.xml");
//    resources[1] = new ClassPathResource("classpath:com/hiwjd/user/UserMapper.xml");
//    sqlSessionFactoryBean.setMapperLocations(resources);

    return sqlSessionFactoryBean;
  }

  @Bean
  @Autowired
  public UserService userService(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
    return new UserService(sqlSessionFactoryBean.getObject());
  }

  @Bean
  @Autowired
  public OperatorService operatorService(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
    return new OperatorService(sqlSessionFactoryBean.getObject());
  }

  @Bean
  public BalService balService(UserService userService, OperatorService operatorService) {
    return new BalService(userService, operatorService);
  }

  @Bean
  public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

}
