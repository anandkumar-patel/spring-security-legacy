package anand.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/security")
public class MainController {
	
	@ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("developer", "anand");
    }
	
	@GetMapping({"/","/welcome"})
	public String welcomePage() {
		return "welcome";
	}

	@GetMapping("/check")
	public String checkPage(Model model) {
		// Get the Authentication object
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.isAuthenticated()) {
			// Access user details
			String username = authentication.getName();
			Object credentials = authentication.getCredentials(); 
			
			

			// Check authorities (roles)
			boolean hasRoleAdmin = authentication.getAuthorities().stream()
					.anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));

			// Use the retrieved information as needed
			System.out.println("Username: " + username);
			System.out.println("Is Admin: " + hasRoleAdmin);
			System.out.println("Credentials: "+credentials);
			
			model.addAttribute("username", username);
		} else {
			// Handle the case where the user is not authenticated
			System.out.println("User is not authenticated");
		}
	
		return "check";
	}

}
