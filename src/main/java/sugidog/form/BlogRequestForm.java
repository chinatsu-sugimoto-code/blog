package sugidog.form;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

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
	private String created;

	//画像データ
	private MultipartFile image;

	//タグ
	private String tags;

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

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
