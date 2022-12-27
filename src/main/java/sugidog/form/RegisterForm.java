package sugidog.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {

	private String email;

	private String password;

	private String nickName;

	private MultipartFile image;

	private String sex;

	private String selfIntroducion;

	private String contentType;

}
