package com.qa.nbg_ims.repositories;

import java.util.List;

import com.qa.nbg_ims.entities.Stock;
import com.qa.nbg_ims.util.ProductStatus;

public interface StockRepository {
	public void persistStock(Stock stock);
	
	public List<Stock> findByStatus(ProductStatus status);
	public Stock findByID(long id);
	public List<Stock> findByLowStock();
	
	public void updateStock(Stock stock);
}