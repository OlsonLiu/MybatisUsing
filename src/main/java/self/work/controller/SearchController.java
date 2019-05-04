package self.work.controller;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import self.work.dao.bean.Employee;
import self.work.service.EmployeeService;

@RestController
@RequestMapping("/search")
public class SearchController {

  private EmployeeService employeeService;

  @Autowired
  public SearchController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/emp")
  public List<Employee> searchAllEmployee() {
    List<Employee> employees = employeeService.searchEmployeeByNumber(null);
    return employees;
  }

  @GetMapping("/emp/{employeeNumber}")
  public List<Employee> searchEmployee(@PathVariable("employeeNumber") Integer employeeNumber) {
    List<Employee> employees = employeeService
        .searchEmployeeByNumber(Collections.singleton(employeeNumber));
    return employees;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/emp", params = {"employeeNumbers"})
  public List<Employee> searchMultiEmployee(
      @RequestParam("employeeNumbers") List<Integer> employeeNumbers) {
    Set<Integer> searchNumbs = employeeNumbers.stream().collect(Collectors.toSet());
    List<Employee> employees = employeeService.searchEmployeeByNumber(searchNumbs);
    return employees;
  }

}
