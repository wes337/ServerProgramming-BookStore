package fi.haagahelia.demo.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.demo.bookstore.domain.UserRepository;
import fi.haagahelia.demo.bookstore.domain.User;
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
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Science Fiction"));
			crepository.save(new Category("Historical Fiction"));
			
			Book b1 = new Book("The Witch", "Camilla Lackberg", "38949029-3", 2017, 10, crepository.findByName("Fantasy").get(0));
			repository.save(b1);
			Book b2 = new Book("Animal Farm", "George Orwell", "045228424-4", 1945, 10, crepository.findByName("Fiction").get(0));
			repository.save(b2);
			Book b3 = new Book("The Chrysalids", "John Wyndham", "159017292-2", 1955, 10, crepository.findByName("Science Fiction").get(0));
			repository.save(b3);
			Book b4 = new Book("All The Light We Cannot See", "Anthony Doerr", "8147674658-6", 2014, 10, crepository.findByName("Historical Fiction").get(0));
			repository.save(b4);
			Book b5 = new Book("The Dark Tower: The Gunslinger", "Stephen King", "9150116180-3", 1982, 10, crepository.findByName("Fantasy").get(0));
			repository.save(b5);
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}
}
