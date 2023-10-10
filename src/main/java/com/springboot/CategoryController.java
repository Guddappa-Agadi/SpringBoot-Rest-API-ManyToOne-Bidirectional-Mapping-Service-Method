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
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService cs;

	@PostMapping("/add")
	public void save(@RequestBody Category c) {
		cs.save(c);
	}

	@PutMapping("/get/{id}")
	public void update(@PathVariable("id") int category_id, @RequestBody Category c) {
		cs.update(c);
	}

	@DeleteMapping("/get/{id}")
	public void delete(@PathVariable("id") int category_id) {
		cs.delete(category_id);
	}

	@GetMapping("/get/{id}")
	public Category getById(@PathVariable("id") int category_id) {
		return cs.getById(category_id);
	}

	@GetMapping("/get")
	public List<Category> getAll() {
		return cs.getAll();
	}

	@GetMapping("/get/page")
	public List<Category> getAll(@RequestParam int page, @RequestParam int size, @RequestParam String field) {
		return cs.getAll(page, size, field);
	}

}
