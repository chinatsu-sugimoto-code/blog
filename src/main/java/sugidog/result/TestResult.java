package sugidog.result;

public class TestResult {

	private int id;

	private int fkBlogId;

	private String image;

	private String contentType;

	private String tag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFkBlogId() {
		return fkBlogId;
	}

	public void setFkBlogId(int fkBlogId) {
		this.fkBlogId = fkBlogId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
