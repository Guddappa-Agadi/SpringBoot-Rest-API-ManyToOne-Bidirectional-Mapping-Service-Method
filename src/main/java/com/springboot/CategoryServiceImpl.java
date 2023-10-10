package com.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository cr;

	@Override
	public void save(Category c) {
		cr.save(c);
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Category c) {
		cr.save(c);
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int category_id) {
		cr.deleteById(category_id);
		// TODO Auto-generated method stub

	}

	@Override
	public Category getById(int category_id) {
		Optional<Category> obj = cr.findById(category_id);
		if (obj.isPresent()) {
			return obj.get();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAll() {
		Iterable<Category> irt = cr.findAll();
		List<Category> lst = new ArrayList<Category>();
		irt.forEach(e -> lst.add(e));
		// TODO Auto-generated method stub
		return lst;
	}

	@Override
	public List<Category> getAll(int page, int size, String field) {
		Pageable p = PageRequest.of(page, size, Direction.ASC, field);
		Page<Category> pa = cr.findAll(p);
		// TODO Auto-generated method stub
		return pa.getContent();
	}

}
