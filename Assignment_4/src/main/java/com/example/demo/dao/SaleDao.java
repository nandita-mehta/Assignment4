package com.example.demo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sale;

@Component
public class SaleDao {
	private EntityManager entityManager;
	
	@Autowired
    public SaleDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
	public void deleteSaleById(long id) {
        Query query = (Query) entityManager.createQuery("delete from sales where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
	public Sale findSaleById(long id) {
    	Sale sale = entityManager.find(Sale.class, id);
        return sale;
    }
    public List<Sale> getAllSales() {
        Query query= (Query) entityManager.createQuery("from sales");
        List<Sale> sale = query.getResultList();
        return sale;
    }
    public Sale saveSale(Sale sale) {
    	Sale dbSale = entityManager.merge(sale);
    	sale.setId(dbSale.getId());
        return sale;
    }
    
}
