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
	/**
	 * 登録ユーザーID
	 */

	private int created;
	/**
	 * 更新ユーザーID
	 */

	private String createdAt;
	private int updated;
	private String updatedAt;
	private int delete_flag;
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public int getUpdated() {
		return updated;
	}
	public void setUpdated(int updated) {
		this.updated = updated;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public int getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}
	
	
}
