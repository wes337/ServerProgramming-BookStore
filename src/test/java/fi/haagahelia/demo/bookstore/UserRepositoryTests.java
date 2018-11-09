package fi.haagahelia.demo.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.demo.bookstore.domain.User;
import fi.haagahelia.demo.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository urepository;

	@Test
	public void findByUsernameShouldReturnUser() {
		User users = urepository.findByUsername("user");
		assertThat(users.getUsername()).isEqualTo("user");

	}

	@Test
	public void createNewUser() {
		User testuser = new User("test", "test", "USER");
		urepository.save(testuser);
		assertThat(testuser.getUsername()).isNotNull();
	}

}
