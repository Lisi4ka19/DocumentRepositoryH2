package documentrepositoryh2security.web;

import documentrepositoryh2security.dto.UserRegistrationDto;
import documentrepositoryh2security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;

//	public RegistrationController(UserService userService) {
//		super();
//		this.userService = userService;
//	}

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new UserRegistrationDto());
		return "registr";
	}

	@PostMapping
	public String registerUserAccount(Model model, @ModelAttribute("user") UserRegistrationDto registrationDto) {

		userService.save(registrationDto);
		model.addAttribute("user",registrationDto);
		return "redirect:/registration?success";
	}
}
