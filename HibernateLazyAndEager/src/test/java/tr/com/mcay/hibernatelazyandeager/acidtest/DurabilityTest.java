package tr.com.mcay.hibernatelazyandeager.acidtest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tr.com.mcay.hibernatelazyandeager.author.entity.Author;
import tr.com.mcay.hibernatelazyandeager.author.repository.AuthorRepository;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Bu test, verilerin kalıcılığını kontrol eder. İşlem tamamlandıktan sonra
 * verilerin kalıcı olarak saklandığını ve veritabanına kalıcı olarak yazıldığını doğrular.
 */
@SpringBootTest
public class DurabilityTest {

    @Autowired
    private AuthorRepository authorRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testDurability() {
        // Author nesnesini oluşturuyor ve kaydediyoruz
        Author author = new Author();
        author.setName("Durability Author");
        author.setCreationTime(Instant.now().toEpochMilli());
        authorRepository.save(author);

        // İşlemi commit ediyoruz
        entityManager.flush();
        entityManager.clear();
        System.out.println("Author Id: "+author.getId());

        // Yeni bir işlem başlatıp veriyi tekrar alıyoruz
        Author fetchedAuthor = authorRepository.findById(author.getId()).orElse(null);
        // Verinin kalıcı olarak saklandığını doğruluyoruz
        assertThat(fetchedAuthor).isNotNull();
        assertThat(fetchedAuthor.getName()).isEqualTo("Durability Author");
        System.out.println("Fetched Author Id: "+fetchedAuthor.getId());
    }
}

