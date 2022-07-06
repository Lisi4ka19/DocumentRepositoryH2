package documentrepositoryh2security.service;

import documentrepositoryh2security.dto.UserRegistrationDto;
import documentrepositoryh2security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);

	List<User> getAll();
}
