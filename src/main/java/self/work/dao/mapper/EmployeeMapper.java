package self.work.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import self.work.dao.bean.Employee;

@Mapper
public interface EmployeeMapper {
  List<Employee> selectEmployees();
}
