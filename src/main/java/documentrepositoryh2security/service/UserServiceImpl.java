package documentrepositoryh2security.service;

import documentrepositoryh2security.dto.UserRegistrationDto;
import documentrepositoryh2security.model.Role;
import documentrepositoryh2security.model.User;
import documentrepositoryh2security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User setEnable(String userName) {

		User user = userRepository.findByName(userName);

		user.setEnable(true);
		userRepository.save(user);

		return null;
	}

	@Override
	public User create(UserRegistrationDto registrationDto) {

		User user = new User(registrationDto.getName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()),false, Arrays.asList(new Role("ROLE_USER")));

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {

		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public List<User> getAll() {

		return userRepository.findAll();
	}

	@Override
	public User getUser(String name){
		return userRepository.findByName(name);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAllByEnable() {
		return userRepository.getAllByEnable(true);
	}


}
