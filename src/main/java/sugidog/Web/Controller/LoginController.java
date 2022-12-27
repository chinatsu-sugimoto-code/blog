package sugidog.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sugidog.Service.UserService;
import sugidog.result.UserDetailResult;

@Controller
@RequestMapping("user")
public class LoginController {

	String test = "user";

	@Autowired
	UserService userService;

	@GetMapping("login")

	public String login() {
		return "user/login";
	}

	@GetMapping("home")
	public String loginTop(Model model) {

		//ログインしているユーザーの情報を取得
		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		model.addAttribute("name", name.substring(0, name.indexOf("@")));

		UserDetailResult userDetailResult = userService.userResult(name);

		model.addAttribute("userDetailResult", userDetailResult);

		return "user/home";
	}

}
