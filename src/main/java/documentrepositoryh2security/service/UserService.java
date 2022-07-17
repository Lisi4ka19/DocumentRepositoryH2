package documentrepositoryh2security.service;

import documentrepositoryh2security.dto.UserRegistrationDto;
import documentrepositoryh2security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

	User setEnable(String userName);

	User create(UserRegistrationDto registrationDto);

	List<User> getAll();

	User getUser(String name);

	void save(User user);

	List<User> getAllByEnable();
}
