package sugidog.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
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
import sugidog.result.BlogDetailResult;
import sugidog.result.BlogResult;
import sugidog.util.DateUtil;

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
	public void create(BlogRequestForm blogRequestForm, String name)
			throws IOException {

		Blog blog = new Blog();
		DateUtil dateUtil = new DateUtil();

		blog.setFkUserName(name);
		blog.setTitle(blogRequestForm.getTitle());
		blog.setContents(blogRequestForm.getContents());
		blog.setCreated(blogRequestForm.getCreated());
		blog.setCreatedAt(dateUtil.getCurrentDateTime());
		blog.setUpdatedAt(dateUtil.getCurrentDateTime());
		blog.setDeleteFlag(0);
		Blog newBlog = blogRepository.save(blog);

		MultipartFile file = blogRequestForm.getImage();

		BlogDetail blogDetail = new BlogDetail();
		blogDetail.setFkBlogId(newBlog.getId());
		blogDetail.setImage(file.getBytes());
		blogDetail.setContentType(file.getContentType());
		blogDetail.setTag(blogRequestForm.getTags());

		blogDetailRepository.save(blogDetail);

	}

	public List<BlogResult> result() {

		List<Blog> blogResult = blogRepository.findAll();

		List<BlogResult> blogResultList = new ArrayList<>();

		for (Blog blog : blogResult) {

			List<BlogDetailResult> blogDetailResultList = new ArrayList<>();
			BlogResult result = new BlogResult();

			result.setId(blog.getId());
			result.setTitle(blog.getTitle());
			result.setContents(blog.getContents());

			List<BlogDetail> blogDiteilList = blog.getBlogDetailList();

			result.setDetailList(blogDitailList(blogDetailResultList, blogDiteilList));

			blogResultList.add(result);
		}

		return blogResultList;

	}

	public List<BlogDetailResult> blogDitailList(List<BlogDetailResult> blogDetailResultList,
			List<BlogDetail> blogDiteilList) {

		for (BlogDetail detail : blogDiteilList) {

			BlogDetailResult detailResult = new BlogDetailResult();

			byte[] bytes = detail.getImage();
			String image = Base64.getEncoder().encodeToString(bytes);
			detailResult.setImage(image);

			detailResult.setContentType(detail.getContentType());
			detailResult.setTag(detail.getTag());
			blogDetailResultList.add(detailResult);

		}

		return blogDetailResultList;
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
