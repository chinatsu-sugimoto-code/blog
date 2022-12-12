package sugidog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
 * Blog情報 Entityクラス
 */

@Entity
@Data
@Table(name = "blog")
public class Blog implements Serializable {
	/**
	 * IDs
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
	 *　登録ユーザーID
	 */
	@Column(name = "created")
	private String created;
	/**
	 * 登録日
	 */
	@Column(name = "created_at")
	private String createdAt;
	/**s
	 * 更新ユーザーID
	 */
	@Column(name = "updated")
	private String updated;
	/**
	 * 更新日
	 */
	@Column(name = "updated_at")
	private String updatedAt;
	/**
	 * 削除フラグ
	 */
	@Column(name = "delete_flag")
	private int deleteFlag;

}
