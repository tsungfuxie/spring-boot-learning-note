package person.tsungfuxie.springguidesconsumingrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
	@Bean({"demoWebClient"})
	public WebClient demoWebClient() {
		return WebClient.create("https://quoters.apps.pcfone.io/api/random");
	}
	
	
	@Bean({"permissionSystemApiWebClient"})
	public WebClient psApiWebClient() {
		return WebClient
				.builder()
				.baseUrl("http://asuka.aicenter.allproducts.com/PermissionSystem")
				.build();
	}
	
	

}
