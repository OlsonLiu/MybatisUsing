package self.work.dao.mapper;

import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;
import self.work.dao.bean.Order;

public interface OrderMapper {

  List<Order> selectOrdersById(@Param("orderNumbers") Set<Integer> orderNumbers);
}
