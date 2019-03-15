package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Product;

@Repository("SpringJPAProductDAOImpl")
public class SpringJPAProductDAOImpl implements ProductDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public List<Product> getAllProducts() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery("findAllProducts");
		List<Product> productList=query.getResultList();
		// TODO Auto-generated method stub
		return productList;
	}

	@Override
	public List<String> getCategoriesNames() {
		// TODO Auto-generated method stub
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createNativeQuery("select category_name from product_categories");
		List<String> categoryList=query.getResultList();
		
		return categoryList;
	}

	@Override
	public boolean insertProduct(Product product) {
		// TODO Auto-generated method stub
		boolean productPersisted=false;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
		productPersisted=true;
		
		return productPersisted;
	}

	@Override
	public int checkProduct(Product product) {
		// TODO Auto-generated method stub
		int productExists=0;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createNamedQuery("checkProduct");
		query.setParameter(1, product.getProduct_id());
		query.setParameter(2,product.getProduct_category());
		List<Product> productList=query.getResultList();
		for(Product productDB:productList)
		{
			if(productDB.getProduct_id()==product.getProduct_id())
			{
				productExists=1;
			}
			else if(productDB.getProduct_category().equals(product.getProduct_category()))
			{
			productExists=2;	
			}
			else if(productDB.getProduct_id()==product.getProduct_id() && productDB.getProduct_category().equals(product.getProduct_category()))
			{
			productExists=3;	
			}
		}
		return productExists;
	}

}
