package com.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService cs;

	@PostMapping("/add")
	public void save(@RequestBody Product c) {
		cs.save(c);
	}

	@PutMapping("/get/{id}")
	public void update(@PathVariable("id") int product_id, @RequestBody Product c) {
		cs.update(c);
	}

	@DeleteMapping("/get/{id}")
	public void delete(@PathVariable("id") int product_id) {
		cs.delete(product_id);
	}

	@GetMapping("/get/{id}")
	public Product getById(@PathVariable("id") int product_id) {
		return cs.getById(product_id);
	}

	@GetMapping("/get")
	public List<Product> getAll() {
		return cs.getAll();
	}

	@GetMapping("/get/page")
	public List<Product> getAll(@RequestParam int page, @RequestParam int size, @RequestParam String field) {
		return cs.getAll(page, size, field);
	}

}
