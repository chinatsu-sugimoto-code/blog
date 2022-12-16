package sugidog.Web.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sugidog.Service.BlogDetailService;
import sugidog.Service.BlogService;
import sugidog.entity.Blog;
import sugidog.result.BlogDetailResult;
import sugidog.result.BlogResult;

@Controller
public class GeneralController {

	/**
	 * BLOG情報 Serviceクラス
	 */
	@Autowired
	BlogService blogservice;

	@Autowired
	BlogDetailService blogDetailService;

	/*
	 * ブログTOPページ
	 */
	@GetMapping("/general/top")
	public String top(Model model) {

		List<BlogResult> blogResultList = blogservice.result();
		//TOPページでは、最新の記事のみを表示
		BlogResult article = blogResultList.get(0);
		model.addAttribute("article", article);

		return "general/top";
	}

	/*
	 * ブログ一覧ページ
	 */
	@GetMapping("/general/list")
	public String list(Model model) {

		List<BlogResult> blogResultList = blogservice.result();

		List<BlogDetailResult> blogDetailResultList = new ArrayList<>();

		//タグの取得
		List<BlogDetailResult> blogDetailList = blogDetailService.blogDetailList();

		model.addAttribute("resultList", blogResultList);
		model.addAttribute("blogDetailList", blogDetailList);
		model.addAttribute("blogDetailResultList", blogDetailResultList);

		return "general/list";
	}

	/*
	 * ブログ詳細ページ
	 */
	@GetMapping("/general/detail/{id}")
	public String detail(@PathVariable int id, Model model) {

		Blog article = blogservice.findbyId(id);

		model.addAttribute("article", article);

		return "general/detail";
	}

	/*
	 * ブログ画像ページ
	 */
	@GetMapping("/general/imageList")
	public String imageList(Model model) {

		List<BlogDetailResult> imageList = blogDetailService.blogDetailList();

		model.addAttribute("imageList", imageList);

		return "general/imageList";
	}

}
