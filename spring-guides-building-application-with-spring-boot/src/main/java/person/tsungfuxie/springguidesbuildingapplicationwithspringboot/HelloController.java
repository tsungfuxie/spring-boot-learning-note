/**
 * 
 */
package person.tsungfuxie.springguidesbuildingapplicationwithspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author User
 *
 */

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
