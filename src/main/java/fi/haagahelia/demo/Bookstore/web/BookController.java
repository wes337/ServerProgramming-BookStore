package fi.haagahelia.demo.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	@RequestMapping(value="/index")
	public String Bookstore(Model model) {
		return "index";
	}
}
