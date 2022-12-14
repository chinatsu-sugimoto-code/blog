package sugidog.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import sugidog.entity.Blog;
import sugidog.entity.BlogDetail;
import sugidog.form.BlogRequestForm;
import sugidog.repository.BlogDetailRepository;
import sugidog.repository.BlogRepository;

/**
 * Blog情報 Service
 */
@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private BlogDetailRepository blogDetailRepository;
	/*
	 * Blog情報新規登録
	 * @param blog
	 */
	public void create(BlogRequestForm blogRequestForm)
			throws IOException {
		
//		File fileImg = new File("img/testimg.png");

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(now);
		Blog blog = new Blog();
		
		MultipartFile file = blogRequestForm.getImage();

		BlogDetail FileDB = new BlogDetail(1, file.getBytes(), "タグ");

		blog.setTitle(blogRequestForm.getTitle());
		blog.setContents(blogRequestForm.getContents());
		blog.setCreated(blogRequestForm.getCreated());
		blog.setCreatedAt(strDate);
		blog.setUpdatedAt(strDate);
		blog.setDeleteFlag(0);
//		
//		byte[] image = blogRequestForm.getImage().getBytes();
//		blog.setImage(Base64.getEncoder().encodeToString(image));
		blogDetailRepository.save(FileDB);
		blogRepository.save(blog);

	}

	public List<Blog> serch() {
		return blogRepository.findAll();
	}

	public Blog findbyId(int id) {
		return blogRepository.findById(id).get();

	}

}
