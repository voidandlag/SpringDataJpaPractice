package cn.sm1234.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.sm1234.dao.IProductDao;
import cn.sm1234.domain.Product;

@Repository
public class ProductDaoImpl extends HibernateDaoSupport implements IProductDao {
	
	//注入sessionFactory，为了获取HibernateTemplate
	@Resource(name="sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

	@Override
	public List<Product> findAll() {
		return this.getHibernateTemplate().loadAll(Product.class);
	}

}
