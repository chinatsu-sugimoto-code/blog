package sugidog.form;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

/*
 * Blog情報　リクエストデータ
 */

@Getter
@Setter
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

}
