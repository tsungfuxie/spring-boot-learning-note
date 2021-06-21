package person.tsungfuxie.springguidesconsumingrest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import person.tsungfuxie.springguidesconsumingrest.pojo.FindEmployeeInfoResponsePojo;
import person.tsungfuxie.springguidesconsumingrest.pojo.Quote;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SpringGuidesConsumingRestApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringGuidesConsumingRestApplication.class);
	
//	@Autowired
//	@Qualifier("defaultRestTemplate")
//	RestTemplate restTemplateA;
	
	@Autowired
	@Qualifier("demoWebClient")
	WebClient demoWebClient;
	
	@Autowired
	@Qualifier("permissionSystemApiWebClient")
	WebClient psApiWebClient;

	public static void main(String[] args) {
		SpringApplication.run(SpringGuidesConsumingRestApplication.class, args).close();
	}


	@Bean
	public CommandLineRunner runRestTemplate(@Qualifier("defaultRestTemplate")RestTemplate restTemplate) throws Exception {//RestTemplate restTemplate
		return args -> {
			Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}
	
	@Bean
	public CommandLineRunner runWebClient() throws Exception {
		return args -> {
			Mono<Quote> quote = demoWebClient
					.get()
					.retrieve()
					.bodyToMono(Quote.class);
			Quote tempQuote = quote.block();
			log.info(tempQuote.toString());
		};
	}
	
//	@Bean
//	public CommandLineRunner runWebClient() throws Exception {
//		return args -> {
//			Mono<FindEmployeeInfoResponsePojo> employeeInfoResponse = 
//					psApiWebClient
//					.post()
//					.uri(uriBuilder -> uriBuilder
//						    .path("/api/employee/findEmployeeBaseInfo")
//						    .queryParam("employeeEmail", "selynn@tradeserv.com")
//						    .build())
//					.accept(MediaType.APPLICATION_JSON)
////					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//					.retrieve()
//					.bodyToMono(FindEmployeeInfoResponsePojo.class);
//			
//			FindEmployeeInfoResponsePojo tempFindEmployeeInfoResponsePojo = employeeInfoResponse.block();
//			log.info(tempFindEmployeeInfoResponsePojo.toString());
//		};
//	}

}
