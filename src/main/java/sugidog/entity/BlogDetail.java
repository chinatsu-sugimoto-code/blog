package sugidog.entity;

import java.io.Serializable;

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
 * Blog詳細情報 Entityクラス
 */

@Entity
@Data
@Table(name = "blog_detail")

public class BlogDetail implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fk_blog_id")
	private int fkBlogId;

	// @Lobはサイズが大きいデータのカラムにつける
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "image")
	private byte[] image;

	@Column(name = "content_type")
	private String contentType;

	@Column(name = "tag")
	private String tag;

}
