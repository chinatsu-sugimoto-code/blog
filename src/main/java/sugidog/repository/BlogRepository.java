package sugidog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sugidog.entity.Blog;

/**
 * Blog情報 Repository
 */
@Repository

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
