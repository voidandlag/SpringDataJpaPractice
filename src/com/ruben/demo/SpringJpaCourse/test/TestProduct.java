package com.ruben.demo.SpringJpaCourse.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ruben.demo.SpringJpaCourse.dao.IProductDao;
import com.ruben.demo.SpringJpaCourse.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestProduct {
	
	@Resource
	public IProductDao productDao;
	
	@Test
	@Transactional
	@Rollback(false)
	public void test1() {
		
		Product testProduct = new Product();
		testProduct.setName("testProduct1");
		testProduct.setPrice(Double.valueOf("120.15"));
		testProduct.setStock(1);
		testProduct.setBrand("testBrand1");
		productDao.save(testProduct);
	}
	
	@Test
	public void test2() {

		List<Product> list = productDao.findAll();
		list.forEach(l -> {
			System.out.println("l.getId() : "+l.getId());
			System.out.println("l.getName() : "+l.getName());
			System.out.println("l.getPrice() : "+l.getPrice());
			System.out.println("l.getStock() : "+l.getStock());
			System.out.println("l.getBrand() : "+l.getBrand());
		});
		
	}	
}
