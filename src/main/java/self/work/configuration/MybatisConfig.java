package self.work.configuration;

import com.zaxxer.hikari.HikariDataSource;
import java.io.IOException;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfig {

//  @Value("${spring.datasource.driver-class-name}")
//  public String driver;
//
//  @Value("${spring.datasource.url}")
//  public String url;
//
//  @Value("${spring.datasource.username}")
//  public String username;
//
//  @Value("${spring.datasource.password}")
//  public String password;

  @Bean
  public HikariDataSource getDataSource(
      @Value("${spring.datasource.driver-class-name}") String driver,
      @Value("${spring.datasource.url}") String url,
      @Value("${spring.datasource.username}") String username,
      @Value("${spring.datasource.password}") String password) {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setDriverClassName(driver);
    dataSource.setJdbcUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);

    dataSource.setReadOnly(false);
    dataSource.setConnectionTimeout(30000);
    dataSource.setIdleTimeout(600000);
    dataSource.setMaxLifetime(1800000);
    dataSource.setMaximumPoolSize(15);

    return dataSource;
  }

  @Bean
  public DataSourceTransactionManager transactionManager(HikariDataSource dataSource) {
    DataSourceTransactionManager transactionManager =
        new DataSourceTransactionManager(dataSource);
    return transactionManager;
  }


  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer configurer = new MapperScannerConfigurer();
    configurer.setBasePackage("self.work.dao.mapper.**");
    configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    return configurer;
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {

    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
    sqlSessionFactoryBean.setMapperLocations(
        new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
//    sqlSessionFactoryBean.setPlugins(new Interceptor[] {pageInterceptor()});
    return sqlSessionFactoryBean;
  }

}
