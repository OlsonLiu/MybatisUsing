package self.work.dao.mapper;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableSet;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import self.work.app.MybatisUsingApplication;
import self.work.dao.bean.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisUsingApplication.class)
@WebAppConfiguration
@SuppressWarnings("Integration test")
public class OrderMapperTest {

  @Autowired
  OrderMapper orderMapper;

  @Test
  public void selectOrder_test_all_data() {
    List<Order> orderList = orderMapper.selectOrdersById(new HashSet<>());
    assertThat(orderList.size()).isGreaterThan(10);
  }

  @Test
  public void selectOrder_test_specific_id() {
    List<Order> orderList = orderMapper.selectOrdersById(ImmutableSet.of(10100));
    assertThat(orderList.size()).isEqualTo(1);
    assertThat(orderList.get(0).getCustomer().getCustomerName())
        .isEqualTo("Online Diecast Creations Co.");
  }
}