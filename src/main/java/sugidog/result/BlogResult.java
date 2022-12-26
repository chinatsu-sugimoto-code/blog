package sugidog.result;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BlogResult {

	private int id;

	private String title;

	private String contents;

	private String created;

	private List<BlogDetailResult> detailList;

}
