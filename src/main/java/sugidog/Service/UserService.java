package sugidog.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import sugidog.entity.Blog;
import sugidog.entity.BlogDetail;
import sugidog.entity.User;
import sugidog.entity.UserDetail;
import sugidog.form.RegisterForm;
import sugidog.repository.UserDetailRepository;
import sugidog.repository.UserRepository;
import sugidog.result.BlogDetailResult;
import sugidog.result.BlogResult;
import sugidog.result.UserDetailResult;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserDetailRepository userDetailRepository;

	@Lazy
	@Autowired
	PasswordEncoder passwordEncoder;

	public void createUser(RegisterForm registerForm, String[] test) throws IOException {

		User user = new User();
		user.setEmail(registerForm.getEmail());
		//passwordはハッシュ化する
		user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
		user.setRoles(test.toString());
		User newUser = userRepository.save(user);

		UserDetail userDetail = new UserDetail();
		userDetail.setFkUserName(newUser.getEmail());
		userDetail.setSex(registerForm.getSex());
		userDetail.setNickName(registerForm.getNickName());
		//画像変換
		MultipartFile file = registerForm.getImage();
		userDetail.setContentType(file.getContentType());
		userDetail.setImage(file.getBytes());

		userDetail.setSelfIntroducion(registerForm.getSelfIntroducion());

		userDetailRepository.save(userDetail);

	}

	//1ユーザのblog記事を取得するメソッド
	public List<BlogResult> result(String name) {

		User user = userRepository.findByEmail(name);

		List<Blog> blogList = user.getBlogList();
		List<BlogResult> blogResultList = new ArrayList<>();

		for (Blog blog : blogList) {

			List<BlogDetailResult> blogDetailResultList = new ArrayList<>();
			BlogResult result = new BlogResult();

			result.setId(blog.getId());
			result.setTitle(blog.getTitle());
			result.setContents(blog.getContents());
			List<BlogDetail> blogDiteilList = blog.getBlogDetailList();

			blogDiteilList(blogDetailResultList, blogDiteilList);

			result.setDetailList(blogDetailResultList);

			blogResultList.add(result);
		}

		return blogResultList;

	}

	public List<BlogDetailResult> blogDiteilList(List<BlogDetailResult> blogDetailResultList,
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

	//ユーザー情報を取得するメソッド
	public UserDetailResult userResult(String name) {

		User user = userRepository.findByEmail(name);

		UserDetail userDetailList = user.getUserDetailList().get(0);
		UserDetailResult userDetailResult = new UserDetailResult();

		userDetailResult.setNickName(userDetailList.getNickName());
		byte[] bytes = userDetailList.getImage();
		String image = Base64.getEncoder().encodeToString(bytes);
		userDetailResult.setImage(image);
		userDetailResult.setContentType(userDetailList.getContentType());
		userDetailResult.setSelfIntroducion(userDetailList.getSelfIntroducion());
		userDetailResult.setSex(userDetailList.getSex());

		return userDetailResult;
	}

}
