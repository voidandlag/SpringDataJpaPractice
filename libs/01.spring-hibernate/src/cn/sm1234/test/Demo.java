package cn.sm1234.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.sm1234.dao.IProductDao;
import cn.sm1234.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {

	@Resource
	private IProductDao productDao;
	
	/**
	 * save����
	 */
	@Test
	@Transactional  //�����Ǹ��²����������ڲ��Է����м�������ע��
	@Rollback(false) //ȡ�����Է�����������Զ��ع�
	public void test1(){
		Product product = new Product();
		product.setName("��Ϊ�ֻ�");
		product.setPrice(3000D);
		product.setBrand("��Ϊ");
		product.setStore(1000);
		
		productDao.save(product);
	}
	
	
	/**
	 * findAll����
	 */
	@Test
	public void test2(){
		List<Product> list = productDao.findAll();
		for (Product product : list) {
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getBrand());
		}
	}
	
}
