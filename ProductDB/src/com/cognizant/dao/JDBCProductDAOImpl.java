package com.cognizant.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Product;
import com.cognizant.helper.ConnectionManager;
import com.cognizant.helper.ProductQuery;

@Repository("JDBCProductDAOImpl")
public class JDBCProductDAOImpl implements ProductDAO{
@Autowired
	private ConnectionManager manager;

@Autowired
private ProductQuery productQuery;
@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Connection conn=manager.openConnection();
		List<Product> productList=new ArrayList<Product>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(productQuery.getSelectAllProductsQuery());
			Product product=new Product();
			product.setProduct_id(rs.getInt(1));
			product.setProduct_category(rs.getString(2));
			product.setProduct_name(rs.getString(3));
			product.setProduct_description(rs.getString(4));
			product.setProduct_price(rs.getFloat(5));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	

}
