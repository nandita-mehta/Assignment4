package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SaleDao;
import com.example.demo.model.Sale;
import com.example.demo.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {
	
	@Autowired
	private SaleDao saleDao;
	
    public SaleServiceImpl(SaleDao saleDao) {
    	super();
    	this.saleDao = saleDao;
    }

    @Override
    public void deleteSaleById(long id) {
    	saleDao.findSaleById(id);
    	saleDao.deleteSaleById(id);
    }
    
    @Override
    public List<Sale> findAllSales() {
        return saleDao.getAllSales();
    }

    @Override
    public Sale findSaleById(long id) {
        return saleDao.findSaleById(id);
    }
    
    @Override
    public Sale saveSale(Sale sale) {
    	return saleDao.saveSale(sale);
    }
}