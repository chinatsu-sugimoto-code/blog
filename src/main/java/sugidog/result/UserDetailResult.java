package sugidog.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailResult {

	private int id;

	private int fkUserId;

	private String nickName;

	private String image;

	private String sex;

	private String selfIntroducion;

	private String contentType;

}
