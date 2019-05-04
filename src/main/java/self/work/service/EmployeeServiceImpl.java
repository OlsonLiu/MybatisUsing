package self.work.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.work.dao.bean.Employee;
import self.work.dao.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeMapper employeeMapper;

  @Autowired
  public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
    this.employeeMapper = employeeMapper;
  }

  @Override
  public List<Employee> searchEmployeeByNumber(Set<Integer> employeeNumbers) {
    return employeeMapper.selectEmployees(employeeNumbers);
  }
}
