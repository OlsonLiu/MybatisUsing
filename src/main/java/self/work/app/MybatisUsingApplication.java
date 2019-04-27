package self.work.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"self.work"})
public class MybatisUsingApplication {

	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(MybatisUsingApplication.class);
		springApplication.run(MybatisUsingApplication.class, args);
	}

}
