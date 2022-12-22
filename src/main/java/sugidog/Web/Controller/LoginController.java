package sugidog.Web.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {

	@GetMapping("/user/login")
	public String login() {
		return "user/login";
	}

	@GetMapping("/user/home")
	public String loginTop(Model model) {

		//ログインしているユーザーの情報を取得
		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		model.addAttribute("name", name.substring(0, name.indexOf("@")));

		return "user/home";
	}

}
