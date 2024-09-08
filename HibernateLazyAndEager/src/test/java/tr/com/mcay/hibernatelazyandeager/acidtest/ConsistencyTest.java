package tr.com.mcay.hibernatelazyandeager.acidtest;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tr.com.mcay.hibernatelazyandeager.author.entity.Author;
import tr.com.mcay.hibernatelazyandeager.author.repository.AuthorRepository;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Bu test, veritabanındaki verilerin tutarlılığını test eder.
 * Veritabanına veri ekledikten sonra, verilerin doğru şekilde
 * saklandığını ve geri alındığını doğrular.
 */
@SpringBootTest
public class ConsistencyTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @Transactional
    public void testConsistency() {
        // Author nesnesini oluşturuyor ve kaydediyoruz
        Author author = new Author();
        author.setName("Consistency Author");
        author.setCreationTime(Instant.now().toEpochMilli());
        authorRepository.save(author);
        System.out.println("Author Id: "+author.getId());


        // Veriyi kaydettikten sonra veritabanından tekrar alıyoruz
        Author fetchedAuthor = authorRepository.findById(author.getId()).orElse(null);
        // Verinin doğru şekilde kaydedildiğini doğruluyoruz
        assertThat(fetchedAuthor).isNotNull();
        assertThat(fetchedAuthor.getName()).isEqualTo("Consistency Author");
    }
}

