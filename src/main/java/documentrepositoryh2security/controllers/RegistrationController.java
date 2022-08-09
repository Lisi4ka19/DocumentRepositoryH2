package documentrepositoryh2security.controllers;

import documentrepositoryh2security.operations.RegistrationOperation;
import documentrepositoryh2security.dto.UserRegistrationDto;
import documentrepositoryh2security.dto.VerificationToken;
import documentrepositoryh2security.model.User;
import documentrepositoryh2security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class RegistrationController {

	private String userName;
	private boolean success;


	@Autowired
	private UserService userService;


	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}




	@GetMapping("/registration")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new UserRegistrationDto());
		success = false;
		return "registr";
	}

	@PostMapping("/registration")
	public String registerUserAccount(Model model, @Valid @ModelAttribute("user") UserRegistrationDto registrationDto,
										BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("user", registrationDto);
			success = false;
			return "registr";
		}


		userService.create(registrationDto);

		userName = registrationDto.getName();


		return "redirect:/verification";
	}

	@GetMapping("/verification")
	public String showVerification(Model model){

		String rightVerificationToken = RegistrationOperation.genRandomPwd(20);
		VerificationToken verificationToken = new VerificationToken(userName, rightVerificationToken);

		model.addAttribute("verificationToken",verificationToken);

		model.addAttribute("success",success);

		return "verificationEmail";
	}

	@PostMapping("/verification")
	public String verificationUser(Model model, @ModelAttribute("verificationToken") VerificationToken verificationToken){

		if(verificationToken.getVerificationCode().equals(verificationToken.getRightVerificationCode())) {

			User user = userService.getUser(verificationToken.getUserName());
			user.setEnable(true);
			userService.save(user);
			success = true;
			return "redirect:/verification?success";
		}
		else{
			return "redirect:/verification?error";
		}
	}



}
