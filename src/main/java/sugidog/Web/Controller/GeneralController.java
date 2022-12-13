package sugidog.Web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sugidog.Service.BlogService;
import sugidog.entity.Blog;

@Controller
public class GeneralController {

	/**
	 * BLOG情報 Serviceクラス
	 */
	@Autowired
	BlogService blogservice;

	/*
	 * ブログTOPページ
	 */
	@GetMapping("/general/top")
	public String top(Model model) {

		List<Blog> resultList = blogservice.serch();
		//TOPページでは、最新の記事のみを表示
		Blog article = resultList.get(0);
		model.addAttribute("article", article);

		return "general/top";
	}

	/*
	 * ブログTOPページ
	 */
	@GetMapping("/general/list")
	public String list(Model model) {

		List<Blog> resultList = blogservice.serch();
		model.addAttribute("resultList", resultList);

		return "general/list";
	}

	/*
	 * ブログTOPページ
	 */
	@GetMapping("/general/detail/{id}")
	public String detail(@PathVariable int id, Model model) {

		Blog article = blogservice.findbyId(id);

		model.addAttribute("article", article);

		return "general/detail";
	}

}
