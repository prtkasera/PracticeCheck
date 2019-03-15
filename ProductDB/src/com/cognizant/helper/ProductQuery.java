package com.cognizant.helper;

public class ProductQuery {
	private String selectAllProductsQuery;
	private String selectProductCategoryName;
	private String insertProduct;
	private String checkProduct;
	
	public String getInsertProduct() {
		return insertProduct;
	}

	public void setInsertProduct(String insertProduct) {
		this.insertProduct = insertProduct;
	}

	public String getCheckProduct() {
		return checkProduct;
	}

	public void setCheckProduct(String checkProduct) {
		this.checkProduct = checkProduct;
	}

	
	public String getSelectProductCategoryName() {
		return selectProductCategoryName;
	}

	public void setSelectProductCategoryName(String selectProductCategoryName) {
		this.selectProductCategoryName = selectProductCategoryName;
	}

	public String getSelectAllProductsQuery() {
		return selectAllProductsQuery;
	}

	public void setSelectAllProductsQuery(String selectAllProductsQuery) {
		this.selectAllProductsQuery = selectAllProductsQuery;
	}
	

	
}
