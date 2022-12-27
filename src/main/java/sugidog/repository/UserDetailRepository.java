package sugidog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sugidog.entity.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {


}