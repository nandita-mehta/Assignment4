package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sale;
import com.example.demo.service.SaleService;

@RestController
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired
	private SaleService saleService;

	public SaleController(SaleService saleService) {
		super();
		this.saleService = saleService;
	}
	
	@PostMapping
	public ResponseEntity<Sale> saveSale(@RequestBody Sale sale) {
		return new ResponseEntity<Sale>(saleService.saveSale(sale), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Sale> getAllSales() {
		return saleService.findAllSales();
	}

	@GetMapping("{id}")
	public ResponseEntity<Sale> findSaleById(@PathVariable("id") long id) {
		return new ResponseEntity<Sale>(saleService.findSaleById(id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteSale(@PathVariable("id") long id) {
		saleService.deleteSaleById(id);
		return new ResponseEntity<String>("Sale deleted successfully!.", HttpStatus.OK);
	}
}