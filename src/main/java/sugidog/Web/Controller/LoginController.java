package sugidog.Web.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {

	//ログイン画面への遷移
	@GetMapping("/login")
	String getLogin(Model model) {
		return "login";
	}

	@GetMapping("/eroor") //errorが発生した際はエラーメッセージを表示したいので違う処理に入るように制御する
	public String getLoginError(Model model) {
		model.addAttribute("ErrorMessage", "*ユーザー名もしくはパスワードが一致しません");
		return "login";
	}

	//デフォルトではPostでリクエストが発生。カスタマイズ時はユーザーが指定したmethodに従う。
//	@PostMapping("/login")
//	public String postLogin(Model model) {
//
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		 String userName = auth.getName();
//		 model.addAttribute("userName", userName);
//		
//		return "sample";
//	}

}
