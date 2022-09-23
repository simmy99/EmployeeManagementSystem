package employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import employee.dto.RegistrationDTO;
import employee.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	private UserService userService;

	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public RegistrationDTO userRegistrationDto() {
        return new RegistrationDTO();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") RegistrationDTO registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}

}
