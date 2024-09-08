package tr.com.mcay.hibernatelazyandeager.acidtest;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tr.com.mcay.hibernatelazyandeager.author.entity.Book;
import tr.com.mcay.hibernatelazyandeager.author.repository.AuthorRepository;
import tr.com.mcay.hibernatelazyandeager.author.entity.Author;
import tr.com.mcay.hibernatelazyandeager.author.repository.BookRepository;


import java.sql.SQLException;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *  Bu test, bir işlem (transaction) sırasında bir hata meydana geldiğinde,
 *  işlemin tamamen geri alındığını doğrular. Yani, işlemin bir kısmı tamamlanmış olsa bile,
 *  hata oluştuğunda yapılan tüm değişikliklerin geri alınmasını test ederiz.
 */
@SpringBootTest
public class AtomicityTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testAtomicity() {
        Author author = new Author();

        try {
            // Author nesnesini oluşturuyor ve kaydediyoruz
            author.setName("Atomic Author");
            author.setCreationTime(Instant.now().toEpochMilli());
            authorRepository.save(author);
            System.out.println("Author Id: "+author.getId());

            // Bu noktada kasıtlı olarak bir hata fırlatıyoruz
            throw new RuntimeException("Simulating an error");

            // Book nesnesini oluşturuyor ve kaydediyoruz
        } catch (Exception e) {
            // Hata oluştuğunda, veritabanındaki author kayıtlarının olmaması gerekir
            assertThat(e).isInstanceOf(RuntimeException.class);
            assertThat(authorRepository.findById(author.getId()).isEmpty()).isTrue();
        }
    }
}

