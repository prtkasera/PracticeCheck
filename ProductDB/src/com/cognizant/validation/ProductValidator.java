package com.cognizant.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cognizant.entity.Product;
import com.cognizant.service.ProductService;

@Component
public class ProductValidator implements Validator {

	@Autowired
	private ProductService productService;

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(Product.class);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		Product product=(Product)arg0;
		int productExist=productService.checkProduct(product);
		System.out.println("productExist:"+productExist);
		if(productExist==1)
		{
			arg1.rejectValue("product_id","com.cognizant.entity.Product.product_id.duplicate");
		}
		else if(productExist==2)
		{
			arg1.rejectValue("product_category","com.cognizant.entity.Product.product_category.duplicate");
		}
		else if(productExist==3)
		{
			arg1.rejectValue("product_id","com.cognizant.entity.Product.product_id.duplicate");
			arg1.rejectValue("product_category","com.cognizant.entity.Product.product_category.duplicate");
		}
	}
	
}
