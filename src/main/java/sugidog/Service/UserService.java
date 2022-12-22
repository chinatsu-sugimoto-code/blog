package sugidog.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sugidog.entity.Blog;
import sugidog.entity.BlogDetail;
import sugidog.entity.User;
import sugidog.repository.UserRepository;
import sugidog.result.BlogDetailResult;
import sugidog.result.BlogResult;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Lazy
	@Autowired
	PasswordEncoder passwordEncoder;

	public void createUser(String email, String rawPassword, String[] roles) {

		User user = new User();
		user.setEmail(email);
		//passwordはハッシュ化する
		user.setPassword(passwordEncoder.encode(rawPassword));
		user.setRoles(String.join(",", roles));

		userRepository.save(user);

	}

	//ユーザー事のblog記事を取得するメソッド
	public List<BlogResult> result(String name) {

		Optional<User> blogResult = userRepository.findByEmail(name);
		
		User user = blogResult.get();
		List<Blog> blogList = user.getBlogList();
		List<BlogResult> blogResultList = new ArrayList<>();
		
		for (Blog b : blogList) {

			List<BlogDetailResult> blogDetailResultList = new ArrayList<>();
			BlogResult result = new BlogResult();

			result.setId(b.getId());
			result.setTitle(b.getTitle());
			result.setContents(b.getContents());

			for (BlogDetail detail : b.getBlogDetailList()) {

				BlogDetailResult detailResult = new BlogDetailResult();

				byte[] bytes = detail.getImage();
				String image = Base64.getEncoder().encodeToString(bytes);
				detailResult.setImage(image);

				detailResult.setContentType(detail.getContentType());
				detailResult.setTag(detail.getTag());
				blogDetailResultList.add(detailResult);

			}

			result.setDetailList(blogDetailResultList);

			blogResultList.add(result);
		}
		
		
		return blogResultList;

	}

}
