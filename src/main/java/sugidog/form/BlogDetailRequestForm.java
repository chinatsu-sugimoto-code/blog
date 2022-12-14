package sugidog.form;

import java.io.Serializable;
/*
 * Blog詳細情報　リクエストデータ
 */

public class BlogDetailRequestForm implements Serializable {

	//画像データ
	private String image;

	//タグ
	private String tags[];

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

}
