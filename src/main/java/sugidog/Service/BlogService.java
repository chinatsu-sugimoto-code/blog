package sugidog.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(now);
		Blog blog = new Blog();
		
		

		blog.setTitle(blogRequestForm.getTitle());
		blog.setContents(blogRequestForm.getContents());
		blog.setCreated(blog.getCreated());
		blog.setCreatedAt(strDate);
		//更新者ID
//		blog.setUpdated(strDate);
		blog.setUpdatedAt(strDate);
		blog.setDeleteFlag(0);
		blogRepository.save(blog);

	}
	
	public List<Blog> serch(){
		return blogRepository.findAll();
	}

}
