package sugidog.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "roles")
	private String roles;

	@OneToMany
	@JoinColumns({
			@JoinColumn(name = "fk_user_name", referencedColumnName = "email", insertable = false, updatable = false)
	})
	private List<Blog> blogList;

	@OneToMany
	@JoinColumns({
			@JoinColumn(name = "fk_user_name", referencedColumnName = "email", insertable = false, updatable = false)
	})
	private List<UserDetail> userDetailList;

}
