package th2;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import th2.data.ProductRepository;

@Slf4j
@Controller
public class WebController {

	private final ProductRepository productRepo;

	@Autowired
	public WebController(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}

	@GetMapping
	public String getIndex() {
		return "index";
	}

	@GetMapping("/display")
	public String getDisplay(Model model) {
		List<Product> products = productRepo.findAll();
		model.addAttribute("products", products);
		return "display";
	}

	@ModelAttribute(name = "product")
	public Product product() {
		return new Product();
	}

	@GetMapping("/add")
	public String getAdd(Model model) {
		model.addAttribute("product", new Product());
		return "add";
	}

	@PostMapping("/add")
	public String addProduct(@Valid Product product, BindingResult result, Model model) {
		log.info(result + "");
		log.info(product + "");
		if (productRepo.existsById(product.getCode())) {
			result.rejectValue("code", "code", "This code already exists");
		}
		if (result.hasErrors()) {
			return "add";
		}
		productRepo.save(product);
		return "redirect:/display";
	}

	@GetMapping("/edit/{code}")
	public String editProduct(@PathVariable String code, Model model) {
		Optional<Product> product = productRepo.findById(code);
		if (product.isPresent()) {
			model.addAttribute("product", product.get());
		}
		return "edit";
	}

	@PostMapping("/edit/{code}")
	public String doEditProduct(@Valid Product product, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "edit";
		}
		productRepo.save(product);
		return "redirect:/display";
	}

	@GetMapping("/delete/{code}")
	public String confirmDelete(Model model, @PathVariable(name = "code") String code) {
		Product product = productRepo.getById(code);
		model.addAttribute("product", product);
		return "delete";
	}

	@PostMapping("/delete/{code}")
	public String deleteProcess(@RequestParam("submit") String value,
			@PathVariable(name = "code") String code) {
		if (value.equalsIgnoreCase("yes")) {
			productRepo.deleteById(code);
		}
		return "redirect:/display";
	}
}
