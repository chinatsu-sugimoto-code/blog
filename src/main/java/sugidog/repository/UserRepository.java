package sugidog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sugidog.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	

}
