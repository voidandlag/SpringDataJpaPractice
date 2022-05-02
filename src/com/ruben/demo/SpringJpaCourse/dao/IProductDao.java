package com.ruben.demo.SpringJpaCourse.dao;

import java.util.List;

import com.ruben.demo.SpringJpaCourse.entity.Product;

public interface IProductDao {
	
	public void save(Product product);
	
	public List<Product> findAll();
}
