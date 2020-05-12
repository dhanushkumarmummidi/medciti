package com.technocrat.Supplier.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.technocrat.Supplier.Bean.Supplier;
import com.technocrat.Supplier.Bean.SupplierOrderProducts;
import com.technocrat.Supplier.Service.SupplierOrderProductsServiceI;

@RestController
@RequestMapping("/supplierorderproducts")
public class SupplierOrderProductsController {
	
	@Autowired
	SupplierOrderProductsServiceI supplierorderproductsservice;
	
	@RequestMapping(value = "/getSupplierOrderProducts")
	public List<SupplierOrderProducts> getSupplierOrders() {

		return supplierorderproductsservice.get();
	}

	
	@RequestMapping("/getSupplierOrderProductsPagination")
	@ResponseBody
	public List<SupplierOrderProducts> getProducts(@RequestParam(value="pageStart")int pageStart,@RequestParam(value="pageEnd")int pageEnd){
		
		return supplierorderproductsservice.get(pageStart,pageEnd);
	}
	
	@RequestMapping(value="/getSupplierOrderProductsById")
	@ResponseBody
	public SupplierOrderProducts getSupplierOrderProductsById(@RequestParam(value="id")int id) {
		return supplierorderproductsservice.getSupplierOrderProductsById(id);
	}
	
	@RequestMapping(value="/getSupplierOrderProductsByIdSupplierOrder")
	@ResponseBody
	public List<SupplierOrderProducts> getSupplierOrderProductsByIdSupplierOrder(@RequestParam(value="orderId")int id) {
		return supplierorderproductsservice.getSupplierOrderProductsBySupplierOrder(id);
	}

	@RequestMapping(value = "/addSupplierOrderProducts", method = RequestMethod.POST)
	@ResponseBody
	public void addSupplierOrderProducts(@RequestBody SupplierOrderProducts supplierorderproduct) {
		supplierorderproductsservice.addSupplierOrderProducts(supplierorderproduct);
	}




	@RequestMapping(value = "/updateSupplierOrderProducts", method = RequestMethod.POST)
	@ResponseBody
	public void updateSupplierOrderProducts(@RequestBody SupplierOrderProducts supplierorderproduct) {
		supplierorderproductsservice.updateSupplierOrderProducts(supplierorderproduct);
	}

	@RequestMapping(value = "/deleteSupplierOrderProducts", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteSupplierOrderProducts(@RequestParam(value="id") int id) {
		return supplierorderproductsservice.deleteSupplierOrderProducts(id);
	}
	

}
