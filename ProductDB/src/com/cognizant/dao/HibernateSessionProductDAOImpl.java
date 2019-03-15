package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Product;

@Repository("HibernateSessionProductDAOImpl")
public class HibernateSessionProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List<Product> productList=session.createQuery("from Product").list();
		session.close();
		return productList;
	}

	@Override
	public List<String> getCategoriesNames() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createSQLQuery("select category_name from product_categories");
		List<String> categoryList=query.list();
		session.close();
		return categoryList;
	}

	@Override
	public boolean insertProduct(Product product) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction txn=session.beginTransaction();
		session.persist(product);
		txn.commit();
		session.close();
		return true;
	}

	@Override
	public int checkProduct(Product product) {
		// TODO Auto-generated method stub
		int productExists=0;
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product o where o.product_id=:product_id or o.product_category=:product_category");
		query.setInteger("product_id", product.getProduct_id());
		query.setString("product_category", product.getProduct_category());
		List<Product> productList=query.list();
		for(Product productDB:productList)
		{
		
			if(productDB.getProduct_id()==product.getProduct_id() && !productDB.getProduct_category().equals(product.getProduct_category()))
			{
				productExists=1;
				break;
			}
			else if(productDB.getProduct_category().equals(product.getProduct_category())&& !(productDB.getProduct_id()==product.getProduct_id()))
			{
			productExists=2;	
			break;
			}
			else if(productDB.getProduct_id()==product.getProduct_id() && productDB.getProduct_category().equals(product.getProduct_category()))
			{
			productExists=3;	
			}
		}
		session.close();
		return productExists;
		
	}

	
	
}
