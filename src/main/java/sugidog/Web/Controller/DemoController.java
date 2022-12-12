package sugidog.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sugidog.Service.BlogService;
import sugidog.form.BlogRequestForm;

@Controller
public class DemoController {

	/**
	* BLOG情報 Serviceクラス
	*/
	@Autowired
	BlogService blogservice;

	/*
	 * ぶろぐ一覧を画面に表示
	 */
	@RequestMapping("/demo")
	public String demo(Model model) {
		model.addAttribute("message", "Hello world");
		return "demo";
	}

	@GetMapping(value = "/add")
	public String displayAdd(Model model) {
		model.addAttribute("blogRequestForm", new BlogRequestForm());
		return "add";
	}

	/*
	 * ブログ新規登録画面
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute BlogRequestForm blogRequestForm, Model model) {

		// ユーザー情報の登録
		blogservice.create(blogRequestForm);
		return "create";
	}

	/*
	 * ブログ新規登録
	 * @param blogRequest リクエストデータ
	 * @para model Model
	 * @return ブログ情報一覧画面
	 */
	//	@RequestMapping(value = "/blog/create", method = RequestMethod.POST)
	//	public String create(@ModelAttribute BlogRequest blogRequest, Model model) {
	//		blogRequest.create(blogRequest);
	//		return "redirect:demo";
	//	}
}