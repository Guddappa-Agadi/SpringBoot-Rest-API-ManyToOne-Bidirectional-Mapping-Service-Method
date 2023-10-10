package com.springboot;

import java.util.List;

public interface ProductService {

	public void save(Product c);

	public void update(Product c);

	public void delete(int product_id);

	public Product getById(int product_id);

	public List<Product> getAll();

	public List<Product> getAll(int page, int size, String field);
}
