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
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import org.mybatis.spring.SqlSessionFactoryBean;


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
  public HikariDataSource getDataSource(){
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/demo_db?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
    dataSource.setUsername("root");
    dataSource.setPassword("xxxx");

    dataSource.setReadOnly(false);
    dataSource.setConnectionTimeout(30000);
    dataSource.setIdleTimeout(600000);
    dataSource.setMaxLifetime(1800000);
    dataSource.setMaximumPoolSize(15);

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
  public MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer configurer = new MapperScannerConfigurer();
    configurer.setBasePackage("self.work.dao.mapper");
    configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    return configurer;
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
