package sugidog.Web.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sugidog.Service.UserService;
import sugidog.form.RegisterForm;

@Controller

public class UserRegisterController {

	@Autowired
	UserService userService;

	//登録画面
	@GetMapping("/user/register")
	public String register(Model model) {
		model.addAttribute("registerForm", new RegisterForm());
		return "user/register";
	}

	//登録画面で登録された時の処理
	@PostMapping("/userCreate")
	public String postRegister(
			@ModelAttribute RegisterForm registerForm,
			BindingResult bindingResult) throws IOException {

		String[] test = { "ADMIN", "USER" };
		userService.createUser(
				registerForm.getEmail(),
				registerForm.getPassword(), test);

		// ユーザー登録処理が成功したらログイン画面にリダイレクト
		return "redirect:/login";
	}

}
