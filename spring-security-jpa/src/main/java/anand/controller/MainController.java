package anand.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping({"/", "/welcome"})
	public String welcome() {
		return "Welcome to home screen.....";
	}

	@GetMapping("/user")
	public String user() {
		return "Welcome to user screen.....";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Welcome to admin screen.....";
	}
	
}
