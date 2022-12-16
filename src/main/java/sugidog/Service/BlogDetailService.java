package sugidog.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugidog.entity.BlogDetail;
import sugidog.repository.BlogDetailRepository;
import sugidog.result.BlogDetailResult;

@Service
public class BlogDetailService {

	@Autowired
	private BlogDetailRepository blogDetailRepository;

	public List<BlogDetailResult> blogDetailList() {

		List<BlogDetail> blogDetail = blogDetailRepository.findAll();
		List<BlogDetailResult> blogDetailResult = new ArrayList<>();

		for (BlogDetail detail : blogDetail) {

			BlogDetailResult result = new BlogDetailResult();
			result.setContentType(detail.getContentType());

			byte[] bytes = detail.getImage();
			String image = Base64.getEncoder().encodeToString(bytes);
			result.setImage(image);

			result.setTag(detail.getTag());

			blogDetailResult.add(result);
		}

		return blogDetailResult;

	}

}
