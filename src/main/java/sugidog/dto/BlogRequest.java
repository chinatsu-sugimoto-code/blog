package sugidog.dto;

import java.io.Serializable;

/*
 * DTO
 */
public class BlogRequest implements Serializable {
	/*
	 * タイトル
	 */
	private String title;

	/*
	 * コンテンツ
	 */

	private String contents;

	/*
	 * 作成者名
	 */
	private String created;

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

	public void create(BlogRequest blogRequest) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
