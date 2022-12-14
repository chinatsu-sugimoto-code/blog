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

	@Column(name = "image")
	private byte[] image;
	
	@Column(name = "tag")
	private String tags;

}
