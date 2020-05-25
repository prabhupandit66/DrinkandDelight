package com.capgemini.drinkanddelight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.drinkanddelight.entity.ProductStock;
import com.capgemini.drinkanddelight.entity.StockDto;
import com.capgemini.drinkanddelight.exception.ProductOrderNotFoundException;
import com.capgemini.drinkanddelight.exception.StockNotFoundException;
import com.capgemini.drinkanddelight.service.ProductStockServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class ProductStockController {

	@Autowired
	private ProductStockServiceImpl service;
	
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestBody StockDto details ) {
		return service.updateProduct(details.getStockId(),details.getManufactureDate(),details.getExpiryDate(),details.getQualityCheck());
		
	}
	@GetMapping("/getProductSpecs/{stockId}")
	public ProductStock getProductSpecs(@PathVariable String stockId) throws StockNotFoundException {
		ProductStock stock=service.getProductSpecs(stockId);
		if(stock==null)
		{
			throw new StockNotFoundException("stock id not present "+stockId+"please enter valid stock id");
		}
		return stock;
	}
	@GetMapping("/getAllProductSpecs") 
	public List<ProductStock> getProductList()throws StockNotFoundException
	{
	List<ProductStock> list=service.retrieve();
	 if(list==null)
		 throw new StockNotFoundException("sry stock is empty insert value");

		return list;
		
	}
	@PostMapping("/setexitdate/{stockId}")
	public String setExitDate(@RequestBody ProductStock stock)
	{
		return service.setExitDate(stock.getStockId(),stock.getExitDate());
	
	}
//	@GetMapping("/{stockId}")
//	public String doesProductOrderIdExists(@PathVariable String stockId)
//	{
//		String id= service.doesProductOrderIdExists(stockId);
//		if(id==null)
//		{
//			throw new StockNotFoundException("Stock ID not found with id "+stockId);
//		}
//		return service.doesProductOrderIdExists(stockId);
//	}

}
