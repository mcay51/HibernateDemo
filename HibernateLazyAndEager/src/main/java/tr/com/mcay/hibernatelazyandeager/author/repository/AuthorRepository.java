package tr.com.mcay.hibernatelazyandeager.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.hibernatelazyandeager.author.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
