package sugidog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugidog.entity.User;
import sugidog.form.UserForm;
import sugidog.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void userCreate(UserForm userForm) {
		
		
		User user = new User();

		user.setLoginId(userForm.getLoginId());
		user.setPassword(userForm.getPassword());
		user.setUserName(userForm.getUserName());
		user.setAge(userForm.getAge());
		
		
		userRepository.save(user);
		
	}

}
