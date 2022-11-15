package sugidog.Persistense.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * タイトル
	 */
	@Column(name = "title")
	private String title;

	/**
	 * コンテンツ
	 */
	@Column(name = "contents")
	private String contents;

	/**
	 * 作成者名
	 */
	@Column(name = "created")
	private String created;

	/**
	 * 更新日時
	 */
	@Column(name = "updated_at")
	private Date updated_at;
	/**
	 * 登録日時
	 */
	@Column(name = "created_at")
	private Date created_at;
	/**
	 * 削除日時
	 */
	@Column(name = "delete_flag")
	private Date delete_flag;

	public Integer getId() {
		return id;
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

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(Date delete_flag) {
		this.delete_flag = delete_flag;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
