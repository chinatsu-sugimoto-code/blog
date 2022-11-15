package sugidog.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sugidog.dto.BlogRequest;

@Controller
public class DemoController {

	/**
	* BLOG情報 Service
	*/
	@Autowired
	BlogRequest blogRequest;

	/*
	 * ぶろぐ一覧を画面に表示
	 */
	@RequestMapping("/demo")
	public String demo(Model model) {
		model.addAttribute("message", "Hello world");
		return "demo";
	}

	/*
	 * ブログ新規登録画面を表示
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAdd(Model model) {
		model.addAttribute("blogRequest", new BlogRequest());
		return "add";
	}

	/*
	 * ブログ新規登録
	 * @param blogRequest リクエストデータ
	 * @para model Model
	 * @return ブログ情報一覧画面
	 */
	@RequestMapping(value = "/blog/create", method = RequestMethod.POST)
	public String create(@ModelAttribute BlogRequest blogRequest, Model model) {
		blogRequest.create(blogRequest);
		return "redirect:demo";
	}
}