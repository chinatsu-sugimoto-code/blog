package sugidog.Web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sugidog.Service.BlogService;
import sugidog.entity.Blog;
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
	@GetMapping("/list")
	public String demo(Model model) {

		List<Blog> resultList =  blogservice.serch();
		model.addAttribute("resultList", resultList);
		model.addAttribute("message", "Hello world");
		return "list";
	}

	@GetMapping(value = "/add")
	public String displayAdd(Model model) {
		model.addAttribute("blogRequestForm", new BlogRequestForm());
		return "add";
	}

	/*
	 * ブログ新規登録画面
	 */
	@PostMapping("create")
	public String create(@Validated @ModelAttribute BlogRequestForm blogRequestForm, Model model) {

		// ユーザー情報の登録
		blogservice.create(blogRequestForm);
		return "create";
	}
	
	/*
	 * ブログ編集画面
	 */
	@GetMapping("edit")
	public String edit(Model model) {

		// ユーザー情報の登録
		model.addAttribute("message", "edit");
		return "edit";
	}
	
	/*
	 * ブログ編集画面
	 */
//	@GetMapping("top")
//	public String top(Model model) {
//
//		// ユーザー情報の登録
//		model.addAttribute("message", "top");
//		return "top";
//	}


}