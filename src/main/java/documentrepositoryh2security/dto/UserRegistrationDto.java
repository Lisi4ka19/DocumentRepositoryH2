package documentrepositoryh2security.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegistrationDto {

	@Size(min = 2, message = "name must me at least 2 character")
	private String name;

	@Pattern(regexp =".+@.+\\..{2,}", message = "invalid e-mail")
	private String email;

	@Size(min = 1, message = "password must be at least 1 character")
	private String password;

	public UserRegistrationDto() {

	}

	public UserRegistrationDto(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
