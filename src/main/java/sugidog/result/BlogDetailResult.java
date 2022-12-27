package sugidog.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogDetailResult {

	private int id;

	private int fkBlogId;

	private String image;

	private String contentType;

	private String tag;

}
