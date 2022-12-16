package sugidog.result;

import java.util.List;

public class BlogResult {

	private int id;

	private String title;

	private String contents;

	private String created;

	private List<BlogDetailResult> detailList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public List<BlogDetailResult> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<BlogDetailResult> detailList) {
		this.detailList = detailList;
	}

}
