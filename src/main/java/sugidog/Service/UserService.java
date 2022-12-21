package sugidog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sugidog.entity.User;
import sugidog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Lazy
	@Autowired
	PasswordEncoder passwordEncoder;

	public void createUser(String email, String rawPassword, String[] roles) {

		User user = new User();
		user.setEmail(email);
		//passwordはハッシュ化する
		user.setPassword(passwordEncoder.encode(rawPassword));
		user.setRoles(String.join(",", roles));

		userRepository.save(user);

	}

}
