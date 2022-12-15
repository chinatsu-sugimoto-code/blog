package sugidog.result;

import java.util.List;

public class BlogResult {

	private String title;

	private String contents;

	private String created;

	private List<TestResult> detailList;

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

	public List<TestResult> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<TestResult> detailList) {
		this.detailList = detailList;
	}

}
