package self.work.configuration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import self.work.app.MybatisUsingApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={MybatisUsingApplication.class})
@ContextConfiguration
@SuppressWarnings("Integration test: check DB connection")
public class MybatisConfigTest {

  @Autowired
  DataSource dataSource;

  @Test
  public void getDataSource() throws SQLException {
    assertThat(dataSource.getConnection(), is(notNullValue()));
  }
}