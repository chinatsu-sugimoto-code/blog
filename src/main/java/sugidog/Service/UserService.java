package sugidog.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugidog.entity.User;
import sugidog.form.UserForm;
import sugidog.repository.UserRepository;

@Service
public class UserService  {

	@Autowired
	private UserRepository userRepository;

	public void createUser(UserForm userForm) throws IOException {

		User user = new User();
		user.setEmail(userForm.getEmail());
		//passwordはハッシュ化する
//		user.setPassword();
		user.setRoles(String.join(",", userForm.getRoles()));
	
		userRepository.save(user);

	}

}
