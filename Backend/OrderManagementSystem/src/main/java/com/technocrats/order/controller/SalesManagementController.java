package com.technocrats.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.technocrats.order.beans.Sales;
import com.technocrats.order.service.SalesService;

@RestController
@RequestMapping(value="/sales")
public class SalesManagementController {
	
	@Autowired
	SalesService salesService;
	
	@RequestMapping(value="/getInvoiceProducts")
	public void getSales(@RequestParam(value="id") int id) {
		salesService.getAllSales(id);
	}
	@RequestMapping(value="/createSale")
	public void ddSales(@RequestBody Sales sale) {
		salesService.saveSales(sale);
	}

}
