package employee.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import employee.dto.RegistrationDTO;
import employee.model.User;

public interface UserService extends UserDetailsService{
	User save(RegistrationDTO registrationDto);
}