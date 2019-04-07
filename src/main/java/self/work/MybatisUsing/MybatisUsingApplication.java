package self.work.MybatisUsing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages={"com"})
@PropertySource({"classpath:application.yml"})
public class MybatisUsingApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(MybatisUsingApplication.class);
		springApplication.run(MybatisUsingApplication.class, args);
	}

}
