package self.work.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import self.work.app.MybatisUsingApplication;
import self.work.dao.bean.Employee;
import self.work.dao.mapper.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisUsingApplication.class)
@WebAppConfiguration
public class EmployeeServiceImplTest {

  @Mock
  EmployeeMapper employeeMapper;

  @InjectMocks
  EmployeeServiceImpl employeeService;


  @Test
  public void searchEmployeeByNumber() {
    Employee emp = new Employee();
    emp.setEmployeeNumber(1);
    List<Employee> mockResult = Lists.newArrayList(emp);
    Mockito.when(employeeMapper.selectEmployees(null)).thenReturn(mockResult);
    List<Employee> testRes = employeeService.searchEmployeeByNumber(null);
    assertThat(testRes.size(), is(1));
  }
}