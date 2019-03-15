package com.cognizant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			while(rs.next())
			{
				//System.out.println("**in while loop***");
			Product product=new Product();
			product.setProduct_id(rs.getInt("product_id"));
			product.setProduct_category(rs.getString("category"));
			product.setProduct_name(rs.getString("name"));
			product.setProduct_description(rs.getString("description"));
			product.setProduct_price(rs.getFloat("price"));
			productList.add(product);
		}
			}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manager.closeConnection();
		
		return productList;
	}
@Override
public List<String> getCategoriesNames() {
	// TODO Auto-generated method stub
	Connection conn=manager.openConnection();
	List<String> categoryList=new ArrayList<String>();
	try {
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(productQuery.getSelectProductCategoryName());
		while(rs.next())
		{
			categoryList.add(rs.getString("category_name"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	manager.closeConnection();
	
	return categoryList;
}
@Override
public boolean insertProduct(Product product) {
	// TODO Auto-generated method stub
	Connection conn=manager.openConnection();
	boolean productInserted=false;
	try {
		PreparedStatement ps=conn.prepareStatement(productQuery.getInsertProduct());
		ps.setInt(1,product.getProduct_id());
		ps.setString(2, product.getProduct_category());
		ps.setString(3, product.getProduct_name());
		ps.setString(4, product.getProduct_description());
		ps.setFloat(5, product.getProduct_price());
		int rows=ps.executeUpdate();
		if(rows>0)
		{
			productInserted=true;
		}
		else
		{
			productInserted=false;
		}
	} 
	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	manager.closeConnection();
	
	return productInserted;
}
@Override
public boolean checkProduct(Product product) {
	Connection conn=manager.openConnection();
	boolean productExist=false;
	try {
		PreparedStatement ps=conn.prepareStatement(productQuery.getCheckProduct());
		ps.setInt(1,product.getProduct_id());
		ps.setString(2, product.getProduct_category());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			productExist=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	// TODO Auto-generated method stub
	manager.closeConnection();
	return productExist;
}
/*Override
public boolean persistProduct(Product product) {
	// TODO Auto-generated method stub
	return false;
}*/
	

}
