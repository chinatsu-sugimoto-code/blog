package sugidog.Persistense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;

import sugidog.Persistense.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog,Indenter>{
	

}
