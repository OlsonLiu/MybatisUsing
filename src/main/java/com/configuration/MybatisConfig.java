package com.configuration;

import java.io.IOException;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = "com.dao.mapper")
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
  PooledDataSource getDataSource() throws IOException{
    PooledDataSource dataSource = new PooledDataSource();
    dataSource.setDriver(driver);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
  }

  //配置事务管理器
  @Bean
  public DataSourceTransactionManager transactionManager() throws IOException{
    //这里的数据源要和配置SqlSessionFactoryBean中配置的数据源相同，事务才会生效
    DataSourceTransactionManager transactionManager =
        new DataSourceTransactionManager(getDataSource());
    return transactionManager;
  }

  @Bean
  public SqlSessionFactoryBean sqlSessionFactory() throws IOException{
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(getDataSource());
    return sqlSessionFactoryBean;
  }
}
