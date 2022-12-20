package sugidog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sugidog.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

}
