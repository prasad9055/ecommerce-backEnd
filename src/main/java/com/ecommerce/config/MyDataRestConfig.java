package com.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		HttpMethod[] theUnSupportedActions = {HttpMethod.PUT, HttpMethod.DELETE,HttpMethod.POST};
		
		// disable Product HTTP Methods for PUT Delete POST 
		  config.getExposureConfiguration()
		  .forDomainType(Product.class)
		  .withItemExposure((metdata,httpMethods)-> httpMethods.disable(theUnSupportedActions))
		  .withCollectionExposure((metdata,httpMethods)-> httpMethods.disable(theUnSupportedActions));
		
		
		  

			// disable productCategory HTTP Methods for PUT Delete POST 
			  config.getExposureConfiguration()
			  .forDomainType(ProductCategory.class)
			  .withItemExposure((metdata,httpMethods)-> httpMethods.disable(theUnSupportedActions))
			  .withCollectionExposure((metdata,httpMethods)-> httpMethods.disable(theUnSupportedActions));
			
	}
	
	

}
