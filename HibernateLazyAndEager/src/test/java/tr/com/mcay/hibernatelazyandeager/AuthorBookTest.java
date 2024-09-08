package tr.com.mcay.hibernatelazyandeager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tr.com.mcay.hibernatelazyandeager.author.entity.Author;
import tr.com.mcay.hibernatelazyandeager.author.entity.Book;
import tr.com.mcay.hibernatelazyandeager.author.repository.AuthorRepository;
import tr.com.mcay.hibernatelazyandeager.author.repository.BookRepository;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuthorBookTest {
@PersistenceContext
private EntityManager entityManager;


    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testLazyInitializationException() {

        List<Author> authors = entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultList();

        for (Author author : authors) {
            System.out.println("Author: " + author.getName());
            //Transactional olmadığında author name i yazar ve session'ı kapatır.
            for (Book book : author.getBooks()) {
                //burada hata fırlatacaktır.
                System.out.println("Book: " + book.getTitle());
            }
        }
    }
    @Test
    @Transactional
    public void nPlusoneProblem(){
        List<Author> authors=entityManager.createQuery("SELECT a FROM Author a",Author.class).getResultList();

        for(Author author:authors){
            System.out.println("Author: "+author.getName());

            for(Book book:author.getBooks()){
                System.out.println("Book: "+book.getTitle());
            }
        }

    }
}
