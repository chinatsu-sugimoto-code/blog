package sugidog.dto;

import java.io.Serializable;

/*
 * blog情報　リクエストデータ
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

}
