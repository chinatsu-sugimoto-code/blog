package sugidog.Web.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sugidog.Service.DefaultUserDetailsService;

@Controller

public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/test")
	public String test(Model model) {

		//ログインしているユーザーの情報を取得
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal() instanceof DefaultUserDetailsService) {

			DefaultUserDetailsService user = DefaultUserDetailsService.class.cast(authentication.getPrincipal());

			model.addAttribute("userInfo", "現在ログインしているユーザ名：" + user.getClass().getName() + "をコントローラクラスから取得しました。");

		} else {
			model.addAttribute("userInfo", "aaa");
		}

		return "test";
	}

}
