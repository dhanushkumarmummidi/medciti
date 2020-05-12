package com.technocrats.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.technocrats.order.beans.Bill;
import com.technocrats.order.beans.Invoice;
import com.technocrats.order.beans.ResponseBean;
import com.technocrats.order.beans.Sales;
import com.technocrats.order.beans.StatisticsData;
import com.technocrats.order.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class OrderManagementController {

	@Autowired
	InvoiceService invoiceService;
	
//	@RequestMapping("/")
//	@ResponseBody
//	public void placeOrder(int userId) {
//		
//	}
	
	@RequestMapping("/getAllInvoices")
	@ResponseBody
	public ResponseBean<List<Invoice>> getInvoices() {
		ResponseBean<List<Invoice>> response = new ResponseBean<List<Invoice>>();
		try {
			response.setStatus(200);
			response.setData(invoiceService.getAllInvoice());

		} catch (Exception e) {
			response.setStatus(400);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping("/updateInvoice")
	@ResponseBody
	public ResponseBean<Invoice> updateInvoice(@RequestBody Invoice invoice) {
		ResponseBean<Invoice> response = new ResponseBean<Invoice>();
		try {
			response.setStatus(200);
			response.setData(invoiceService.update(invoice));
		} catch (Exception e) {
			response.setStatus(400);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;	
	}
	
	@RequestMapping("/findInvoiceById")
	@ResponseBody
	public ResponseBean<Invoice> findInvoiceById(@RequestParam(value = "id")int id) {
		
		ResponseBean<Invoice> response = new ResponseBean<Invoice>();
		try {
			response.setStatus(200);
			response.setData(invoiceService.getInvoiceById(id).get());
		} catch (Exception e) {
			response.setStatus(400);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value="/createInvoice")
	public ResponseBean<Bill> createSale(@RequestBody Invoice invoice) {
		System.out.println("INOPUT IS "+invoice);
		ResponseBean<Bill> ResponseBill = new ResponseBean<Bill>();
		try {
			Bill bill = invoiceService.createInvoice(invoice);
			ResponseBill.setData(bill);
		} catch (Exception e) {
			ResponseBill.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return ResponseBill;
	}
	@RequestMapping(value="/findSalesStatisticsWithData")
	public List<StatisticsData> findSalesStatisticsWithData(@RequestParam(value="locationId") int locationId) {
		return invoiceService.findSalesStatisticsWithData(locationId);
	}
	
	
}
