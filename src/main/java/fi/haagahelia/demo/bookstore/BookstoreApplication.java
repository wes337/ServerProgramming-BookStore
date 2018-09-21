package fi.haagahelia.demo.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import fi.haagahelia.demo.bookstore.domain.Book;
import fi.haagahelia.demo.bookstore.domain.BookRepository;
import fi.haagahelia.demo.bookstore.domain.Category;
import fi.haagahelia.demo.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("History"));
			
			Book b1 = new Book("The Witch", "Camilla Lackberg", "38949029-3", 2017, 10, crepository.findByName("Fantasy").get(0));
			repository.save(b1);
		};
	}
}
