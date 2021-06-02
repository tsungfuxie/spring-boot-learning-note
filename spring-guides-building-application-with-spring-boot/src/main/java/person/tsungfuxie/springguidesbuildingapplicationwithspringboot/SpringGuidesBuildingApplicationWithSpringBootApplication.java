package person.tsungfuxie.springguidesbuildingapplicationwithspringboot;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringGuidesBuildingApplicationWithSpringBootApplication {
	
	private static Logger logger = LoggerFactory.getLogger(SpringGuidesBuildingApplicationWithSpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringGuidesBuildingApplicationWithSpringBootApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {
			logger.info("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = context.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				logger.info(beanName);
			}
		};
	}

}
