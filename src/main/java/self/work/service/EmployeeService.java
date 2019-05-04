package self.work.service;

import java.util.List;
import java.util.Set;
import self.work.dao.bean.Employee;

public interface EmployeeService {

  List<Employee> searchEmployeeByNumber(Set<Integer> employeeIds);
}
