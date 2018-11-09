package fi.haagahelia.demo.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.demo.bookstore.domain.Category;
import fi.haagahelia.demo.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTests {

	@Autowired
	private CategoryRepository crepository;

	@Test
	public void findByAuthorShouldReturnBook() {
		List<Category> categories = crepository.findByName("Fantasy");

		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Fantasy");
	}

	@Test
	public void createNewCategory() {
		Category testcategory = new Category("Test");
		crepository.save(testcategory);

		assertThat(testcategory.getCategoryid()).isNotNull();
	}

}
