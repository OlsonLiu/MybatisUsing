package com.configuration;

import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import org.mybatis.spring.SqlSessionFactoryBean;


//@MapperScan(basePackages = "com.dao.mapper")
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfig {

  @Value("${spring.datasource.driver-class-name}")
  String driver;
  @Value("${spring.datasource.url}")
  String url;
  @Value("${spring.datasource.username}")
  String username;
  @Value("${spring.datasource.password}")
  String password;


  @Bean
  DataSource getDataSource(){
    return DataSourceBuilder.create()
        .username(username)
        .password(password)
        .url(url)
        .driverClassName(driver)
        .build();
  }


  //配置事务管理器
  @Bean
  public DataSourceTransactionManager transactionManager() throws IOException{
    //这里的数据源要和配置SqlSessionFactoryBean中配置的数据源相同，事务才会生效
    DataSourceTransactionManager transactionManager =
        new DataSourceTransactionManager(getDataSource());
    return transactionManager;
  }

  /*
  @Bean
  public SqlSessionFactoryBean sqlSessionFactory() throws IOException{
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(getDataSource());
    return sqlSessionFactoryBean;
  }
  */
}
