package fi.haagahelia.demo.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.demo.bookstore.domain.Book;
import fi.haagahelia.demo.bookstore.domain.BookRepository;
import fi.haagahelia.demo.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {

	@Autowired
	private BookRepository repository;

	@Test
	public void findByAuthorShouldReturnBook() {
		List<Book> books = repository.findByAuthor("George Orwell");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("George Orwell");
	}

	@Test
	public void createNewBook() {
		Book testbook = new Book("Test", "Test", "123456-7", 2018, 10, new Category("Test"));
		repository.save(testbook);
		assertThat(testbook.getId()).isNotNull();
	}
}
