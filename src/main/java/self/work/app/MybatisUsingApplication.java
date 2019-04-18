package self.work.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages={"self.work"})
@PropertySource({"classpath:application.yml"})
public class MybatisUsingApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(MybatisUsingApplication.class);
		springApplication.run(MybatisUsingApplication.class, args);
	}

}
