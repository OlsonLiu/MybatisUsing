package self.work.dao.mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import self.work.app.MybatisUsingApplication;
import self.work.dao.bean.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisUsingApplication.class)
@WebAppConfiguration
@SuppressWarnings("Integration test")
public class EmployeeMapperTest {

  @Autowired
  EmployeeMapper employeeMapper;

  @Test
  public void selectTest() {
    List<Employee> result = employeeMapper.selectEmployees();
    assertThat(result, is(notNullValue()));
    assertThat(result.size(), is(greaterThan(1)));
  }
}