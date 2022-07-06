package documentrepositoryh2security.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home() {

		System.out.println(getUserName());
		return "index";
	}



	private String getUserName(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username =  auth.getName();

		return username;
	}
}
