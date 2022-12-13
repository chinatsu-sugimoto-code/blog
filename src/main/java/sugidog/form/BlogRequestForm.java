package sugidog.form;

import java.io.Serializable;

/*
 * Blog情報　リクエストデータ
 */

public class BlogRequestForm implements Serializable {
	/**
	 * タイトル
	 */
	//	@NotEmpty(message = "タイトルを入力してください")
	private String title;
	/**
	 * コンテンツ
	 */
	//	@Size(max = 255, message = "コンテンツを入力してください")
	private String contents;

	//作成者ID
	private int created;

	//画像
	private String image;

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

	public int getCreated() {
		return created;
	}

	public void setCreated(int created) {
		this.created = created;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
