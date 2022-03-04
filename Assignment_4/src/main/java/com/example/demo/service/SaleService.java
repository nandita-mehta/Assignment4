package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Sale;

public interface SaleService {
	public void deleteSaleById(long id);
    public List<Sale> findAllSales();
    public Sale findSaleById(long id);
    public Sale saveSale(Sale sale);
}