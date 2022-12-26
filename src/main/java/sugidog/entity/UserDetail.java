package sugidog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

/*
 * User詳細情報 Entityクラス
 */

@Entity
@Data
@Table(name = "user_detail")
public class UserDetail {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fk_user_name")
	private String fkUserName;

	@Column(name = "nickname")
	private String nickName;

	// @Lobはサイズが大きいデータのカラムにつける
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "image")
	private byte[] image;

	@Column(name = "sex")
	private String sex;

	@Column(name = "self_introducion")
	private String selfIntroducion;

	@Column(name = "content_type")
	private String contentType;

}
