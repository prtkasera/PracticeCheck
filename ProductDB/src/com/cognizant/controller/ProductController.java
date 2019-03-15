package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.entity.Product;
import com.cognizant.service.ProductService;
//import com.cognizant.service.ProductServiceImpl;

@Controller
public class ProductController {
 @Autowired
	private ProductService productService;
    @RequestMapping(value="viewProducts.htm",method=RequestMethod.GET)
    public ModelAndView viewProducts()
    {
    	ModelAndView mv=new ModelAndView();
    	List<Product> productList=productService.getAllProducts();
    	//System.out.println(productList);
    	mv.addObject("productList",productList);
    	mv.setViewName("viewProducts");
    	return mv;
    }
    @ModelAttribute("product")
    public Product createCommandObject()
    {
    	Product product=new Product();
    	product.setProduct_id(0);
    	product.setProduct_name("Please type your name");
    	product.setProduct_category("Please type your category");
    	product.setProduct_description("Please type your description");
    	product.setProduct_price(0);
    	return product;
    }
    @ModelAttribute("categorylist")
    public List<String> createProductCategory()
    {
    	return productService.getCategoriesNames();
    }
    
    @RequestMapping(value="productForm.htm",method=RequestMethod.GET)
    public String loadProductForm()
    {
    	return "productform";
    }
	
    @RequestMapping(value="addproduct.htm",method=RequestMethod.POST)
    public ModelAndView persistProduct(@ModelAttribute("product")Product product,Errors errors)
    {
    	ModelAndView mv=new ModelAndView();
    	ValidationUtils.invokeValidator(validator, product, errors);
    	if(errors.hasErrors())
    	{
    	mv.setViewName("productform");	
    	}
    	else{
    	boolean productPersist=productService.persistProduct(product);
    
    	if(productPersist)
    	{
    		mv.addObject("status","Product Successfully Registered");
    	}
    	else
    	{
    		mv.addObject("status","Product Registration Failed");
    	}
    	mv.setViewName("productform");
    	}
    	return mv;
}
    
    @Autowired
    private Validator validator;
}
