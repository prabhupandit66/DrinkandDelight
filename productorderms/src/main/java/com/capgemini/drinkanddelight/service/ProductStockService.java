package com.capgemini.drinkanddelight.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.drinkanddelight.entity.ProductStock;

public interface ProductStockService {
	
    public ProductStock getProductSpecs(String stockId);

    /*
	 * it will display all the stock details
	 */
	public List<ProductStock> retrieve();
	/*
	 * it will update the manufacturing date ,expire date and insert the quality of the product
	 */
	public String updateProduct(String stockId,Date  manufactureDate,Date expiryDate,String qualityCheck );
	/*
	 * it will check whether stock id present or not
	 */
		
//	public String   doesProductOrderIdExists(String stockId);
	/*
	 * it will set the exit date of the product order
	 */
	public String setExitDate(String stockId,Date exitDate);
	

}
