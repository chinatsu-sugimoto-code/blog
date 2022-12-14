package sugidog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sugidog.entity.BlogDetail;

@Repository
public interface BlogDetailRepository extends JpaRepository<BlogDetail, Integer> {

}
