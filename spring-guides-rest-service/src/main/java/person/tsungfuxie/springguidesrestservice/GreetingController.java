package person.tsungfuxie.springguidesrestservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String GREETING_TEMPLATE_STRING = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting sayGreeting(@RequestParam(value = "name", defaultValue = "World", required = false) String name) {
		return new Greeting(counter.incrementAndGet(), String.format(GREETING_TEMPLATE_STRING, name));
	}

}
