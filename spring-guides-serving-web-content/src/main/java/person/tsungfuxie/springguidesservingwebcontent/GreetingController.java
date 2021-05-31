package person.tsungfuxie.springguidesservingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	@GetMapping("/greeting")
	public String getGreeting(
			@RequestParam(value = "name", defaultValue = "World Better", required = false) String name,
			Model model
			) {
		model.addAttribute("name", name);
		return "greeting";
	}

}
