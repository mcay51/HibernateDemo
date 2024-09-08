package tr.com.mcay.hibernatelazyandeager.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.hibernatelazyandeager.author.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
