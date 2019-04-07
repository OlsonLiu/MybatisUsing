package com.configuration;

import com.dao.bean.Student;
import java.sql.SQLException;
import javax.sql.DataSource;
//import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import self.work.MybatisUsing.MybatisUsingApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={MybatisUsingApplication.class})
@ContextConfiguration
public class MybatisConfigTest {

  @Autowired
  DataSource dataSource;

  @Test
  public void getDataSource() throws SQLException {
    System.out.println(dataSource.getConnection());
  }

  @Autowired
  Student student;

  @Test
  public void name() {
    student.setName("test");
    System.out.println(student.getName());
  }
}