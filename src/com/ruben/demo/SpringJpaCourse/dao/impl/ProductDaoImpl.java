package com.ruben.demo.SpringJpaCourse.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ruben.demo.SpringJpaCourse.dao.IProductDao;
import com.ruben.demo.SpringJpaCourse.entity.Product;

@Repository
public class ProductDaoImpl extends HibernateDaoSupport implements IProductDao {

	@Resource(name="sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().loadAll(Product.class);
	}

}
