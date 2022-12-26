package sugidog.Web.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sugidog.Service.BlogService;
import sugidog.Service.UserService;
import sugidog.form.BlogRequestForm;
import sugidog.result.BlogResult;

@Controller
public class BlogController {

	/**
	 * BLOG情報 Serviceクラス
	 */
	@Autowired
	BlogService blogService;

	@Autowired
	UserService userService;

	/*
	 * ブログ一覧を画面に表示
	 */
	@GetMapping("user/list")
	public String list(Model model) throws IOException {


		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		List<BlogResult> result = userService.result(name);

		model.addAttribute("result", result);

		return "user/list";
	}

	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {

		model.addAttribute("blogRequestForm", new BlogRequestForm());
		return "user/add";
	}

	/*
	 * ブログ新規登録画面
	 */
	@PostMapping("user/create")
	public String create(@Validated @ModelAttribute BlogRequestForm blogRequestForm,
			Model model) throws IOException {

		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		blogService.create(blogRequestForm, name);
		return "user/create";
	}

	/*
	 * ブログ編集画面
	 */
	@GetMapping("user/edit")
	public String edit(Model model) {

		model.addAttribute("message", "edit");
		return "user/edit";
	}
}