package tr.com.mcay.hibernatelazyandeager.acidtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tr.com.mcay.hibernatelazyandeager.author.entity.Author;
import tr.com.mcay.hibernatelazyandeager.author.repository.AuthorRepository;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Bu test, veritabanı işlemlerinin izolasyonunu kontrol eder.
 * Bir işlem diğer işlemlerden izole bir şekilde çalıştığında
 * verilerin doğru şekilde okunabilmesini sağlar.
 */
@SpringBootTest
public class IsolationTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testIsolation() {
        // Author nesnesini oluşturuyor ve kaydediyoruz
        Author author = new Author();
        author.setName("Isolation Author");
        author.setCreationTime(Instant.now().toEpochMilli());
        authorRepository.save(author);
System.out.println("Author Id: "+author.getId());
        // Veriyi izole bir işlem içinde alıyoruz
        Author fetchedAuthor = authorRepository.findById(author.getId()).orElse(null);
        // Verinin doğru şekilde yalıtılmış işlemde okunabildiğini doğruluyoruz
        assertThat(fetchedAuthor).isNotNull();
        assertThat(fetchedAuthor.getName()).isEqualTo("Isolation Author");
    }
}

