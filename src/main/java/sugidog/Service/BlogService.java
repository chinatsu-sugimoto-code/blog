package sugidog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugidog.entity.Blog;
import sugidog.form.BlogRequestForm;
import sugidog.repository.BlogRepository;

/**
 * Blog情報 Service
 */
@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	/*
	 * Blog情報新規登録
	 * @param blog
	 */
	public void create(BlogRequestForm blogRequestForm) {
		//TODO:メソッドのないの実装
		//		Date now = new Date();
		Blog blog = new Blog();
//		blog.setId(1);
		blog.setTitle(blogRequestForm.getTitle());
		blog.setContents(blogRequestForm.getContents());
		blog.setCreated(1);
//		blog.setCreatedAt("2020-12-12 01:24:23");
//		blog.setUpdated(2);
////		blog.setUpdatedAt("2020-12-12 01:24:23");
//		blog.setDeleteFlag(0);
		blogRepository.save(blog);

	}

}
