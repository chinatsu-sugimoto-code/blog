package sugidog.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import sugidog.entity.Blog;
import sugidog.entity.BlogDetail;
import sugidog.form.BlogRequestForm;
import sugidog.repository.BlogDetailRepository;
import sugidog.repository.BlogRepository;
import sugidog.result.BlogResult;
import sugidog.result.TestResult;

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

	@ElementCollection
	public void create(BlogRequestForm blogRequestForm)
			throws IOException {

		//		File fileImg = new File("img/testimg.png");

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(now);
		Blog blog = new Blog();

		MultipartFile file = blogRequestForm.getImage();

		BlogDetail blogDetail = new BlogDetail();
		blogDetail.setFkBlogId(2);
		blogDetail.setImage(file.getBytes());
		blogDetail.setContentType(file.getContentType());
		blogDetail.setTag(blogRequestForm.getTags());

		blog.setTitle(blogRequestForm.getTitle());
		blog.setContents(blogRequestForm.getContents());
		blog.setCreated(blogRequestForm.getCreated());
		blog.setCreatedAt(strDate);
		blog.setUpdatedAt(strDate);
		blog.setDeleteFlag(0);
		blogDetailRepository.save(blogDetail);
		blogRepository.save(blog);

	}

	public List<BlogResult> result() {


		List<Blog> blogResult = blogRepository.findAll();

		List<BlogResult> blogResultList = new ArrayList<>();

		List<TestResult> testList = new ArrayList<>();


		for (Blog blog : blogResult) {
			
			BlogResult result = new BlogResult();
			TestResult test = new TestResult();
			
			result.setTitle(blog.getTitle());
			result.setContents(blog.getContents());
			result.setCreated(blog.getCreated());

			List<BlogDetail> blogilList = blog.getBlogDetailList();

			for (BlogDetail detail : blogilList) {
				byte[] bytes = detail.getImage();
				String image = Base64.getEncoder().encodeToString(bytes);
				test.setImage(image);
				test.setContentType(detail.getContentType());
				test.setTag(detail.getTag());
				testList.add(test);
				result.setDetailList(testList);
			}

			
			blogResultList.add(result);
		}

		return blogResultList;

	}

	public List<Blog> blogSerch() {
		return blogRepository.findAll();
	}

	public List<BlogDetail> blogDitailSerch() {
		return blogDetailRepository.findAll();
	}

	public Blog findbyId(int id) {
		return blogRepository.findById(id).get();

	}

}
