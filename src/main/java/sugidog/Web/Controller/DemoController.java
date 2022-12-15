package sugidog.Web.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sugidog.Service.BlogService;
import sugidog.form.BlogRequestForm;
import sugidog.result.BlogResult;

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
	public String demo(Model model) throws IOException {

		List<BlogResult> result = blogservice.result();

//		List<Blog> blogResultList = blogservice.blogSerch();
//
//		//
//		List<BlogDetail> blogDetailResultList = blogservice.blogDitailSerch();


		model.addAttribute("result", result);
//		model.addAttribute("blogResultList", blogResultList);
//		model.addAttribute("blogDetailResultList", blogDetailResultList);
		model.addAttribute("message", "Hello world");

		//画像

		//		String pathname = "C:\\Users\\sugimoto\\Downloads\\25df309d-4272-4fdc-bbaa-3adbce5b5072.jpg";
		//		
		//		File file = new File(pathname);
		//		

		// ファイルのコンテンツタイプをしらべる
		//		String contentType = Files.probeContentType(file.toPath());
		//
		//		// ファイル内容をbyte[]に読み込む
		//		byte[] data = Files.readAllBytes(file.toPath());
		//
		//		// byte[]をbase64文字列に変換する(java7)
		//		String base64str = DatatypeConverter.printBase64Binary(data);
		//
		//		StringBuilder sb = new StringBuilder();
		//		sb.append("data:");
		//		sb.append(contentType);
		//		sb.append(";base64,");
		//		sb.append(base64str);
		//
		//		model.addAttribute("sb", sb);
		//String base64str = Base64.getEncoder().encodeToString(data);

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
	public String create(@Validated @ModelAttribute BlogRequestForm blogRequestForm,
			Model model) throws IOException {

		//画像処理
		//		MultipartFile file = blogRequestForm.getImage();
		//		BlogDetail savedFile = blogservice.create(file);
		//		byte[] bytes = savedFile.getData();
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