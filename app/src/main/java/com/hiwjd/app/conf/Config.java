package com.hiwjd.app.conf;

import com.hiwjd.bal.BalService;
import com.hiwjd.cardealer.CardealerService;
import com.hiwjd.operator.OperatorService;
import com.hiwjd.user.UserService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

//  @Bean
//  public PlatformTransactionManager transactionManager(DataSource dataSource) {
//    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//    transactionManager.setDataSource(dataSource);
//    return transactionManager;
//  }

    @Bean
    public UserService userService(DataSource dataSource) throws Exception {
        return new UserService(dataSource);
    }

    @Bean
    public OperatorService operatorService(DataSource dataSource) throws Exception {
        return new OperatorService(dataSource);
    }

    @Bean
    public BalService balService(UserService userService, OperatorService operatorService) {
        return new BalService(userService, operatorService);
    }

    @Bean
    public CardealerService cardealerService(BalService balService, DataSource dataSource) throws Exception {
        return new CardealerService(balService, dataSource);
    }

}
