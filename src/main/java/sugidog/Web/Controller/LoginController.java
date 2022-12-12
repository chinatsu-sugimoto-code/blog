package sugidog.Web.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("login")
public class LoginController {
	
	    //ログイン画面への遷移
	    @GetMapping
	    String getLogin() {
	        return "login";
	    }

}
