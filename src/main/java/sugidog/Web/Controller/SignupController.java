//package sugidog.Web.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import sugidog.Service.UserService;
//import sugidog.form.UserForm;
//
//@Controller
//public class SignupController {
//
//	@Autowired
//	UserService userService;
//
//	/*
//	 * ユーザー新規登録画面
//	 */
//	@GetMapping(value = "/user/register")
//	public String postSignUp(Model model) {
//
//		model.addAttribute("userForm", new UserForm());
//
//		return "/user/register";
//	}
//
//	/*
//	 * ユーザー新規登録機能
//	 */
////	@PostMapping("/signup")
////	public String create(@Validated @ModelAttribute UserForm userForm,
////			Model model) throws IOException {
////
////		userService.userCreate(userForm);
////		return "user/userCreate";
////	}
//}
