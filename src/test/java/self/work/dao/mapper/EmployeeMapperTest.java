package self.work.dao.mapper;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import self.work.app.MybatisUsingApplication;
import self.work.configuration.MybatisConfig;
import self.work.dao.bean.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisUsingApplication.class)
@WebAppConfiguration
public class EmployeeMapperTest {

  @Autowired
  EmployeeMapper employeeMapper;

  @Test
  public void selectTest() {
    List<Employee> result = employeeMapper.selectEmployees();
    result.forEach(employee -> {
      System.out.println(employee.getLastName());
    });
  }
}