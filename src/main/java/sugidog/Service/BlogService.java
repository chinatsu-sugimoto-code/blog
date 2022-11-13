package sugidog.Service;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugidog.Persistense.entity.Blog;
import sugidog.Persistense.repository.BlogRepository;
import sugidog.dto.BlogRequest;

/*
 * 
 * 
 * bぉg情報(ビジネスオブジェクト)
 * 
 * */
@Service
public class BlogService {
	
	/**
	 * ブログ情報
	 */
	
	@Autowired
	BlogRepository blogRepository;
	
	/*
	 * 
	 * blog記事一覧　全検索した時
	 * 
	 * */
	public List<Blog>serchAll() {
		
		return blogRepository.findAll();
	}
	
	/*
	 * blog新規登録
	 */
	
	public void create(BlogRequest blogRequest) {
		blogRepository.save(CreateBlog(blogRequest));
	}
	
	/*
	 * blogのエンティティの生成
	 * @param blogRequest ブログ情報リクエストデータ
	 *  
	 */
	private Blog CreateBlog(BlogRequest blogRequest) {
		Data now = (Data) new Date();
		
		Blog blog = new Blog();
	    blog.setTitle(blogRequest.getTitle());
	    blog.setContents(blogRequest.getContents());
	    blog.setCreated(blogRequest.getCreated());
	    blog.setUpdated_at(now);
	    
	    return blog;
	    		
	}
	
	

}
