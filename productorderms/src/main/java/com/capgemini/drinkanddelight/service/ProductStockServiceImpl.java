package com.capgemini.drinkanddelight.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.drinkanddelight.dao.ProductStockDao;
import com.capgemini.drinkanddelight.entity.ProductStock;

@Service
@Transactional
public class ProductStockServiceImpl implements ProductStockService{
	
	@Autowired
	private ProductStockDao daoObj;

	@Override
	public ProductStock getProductSpecs(String stockId) {
		return daoObj.findById(stockId).get();
	}

	@Override
	public List<ProductStock> retrieve() {
		return  daoObj.findAll();
	}

	@Override
	public String updateProduct(String stockId, Date manufactureDate, Date expiryDate, String qualityCheck) {
		 Optional<ProductStock> order=daoObj.findById(stockId);
         if(order.isPresent())
         {
      	   ProductStock stock= order.get();
      	   stock.setManufactureDate(manufactureDate);
      	   stock.setExpiryDate(expiryDate);
      	   stock.setQualityCheck(qualityCheck);
      	   return "Product Stock Updated Successfully";
      	   
         }
		return "Missing details";
	}

	

//	@Override
//	public String doesProductOrderIdExists(String stockId) {
//		if(daoObj.existsById(stockId))
//		{
//			return "Stock Id exist";
//		}
//		return null;
//	}

	@Override
	public String setExitDate(String stockId, Date exitDate) {
		 Optional<ProductStock> order=daoObj.findById(stockId);
         if(order.isPresent())
         {
      	   ProductStock stock= order.get();
      	   stock.setExitDate(exitDate);
      	   return "Exit Date set Successfully";
         }
		return "Unsuccessfull attempt";
	}
	}
	
	


