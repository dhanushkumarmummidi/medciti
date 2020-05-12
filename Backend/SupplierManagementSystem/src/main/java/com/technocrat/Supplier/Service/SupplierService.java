package com.technocrat.Supplier.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.technocrat.Supplier.Bean.ResponseInventryOrder;
import com.technocrat.Supplier.Bean.StoreProducts;
import com.technocrat.Supplier.Bean.Supplier;
import com.technocrat.Supplier.Bean.SupplierOrderProducts;
import com.technocrat.Supplier.Dao.SupplierDaoI;

@Service
public class SupplierService implements SupplierServiceI{

	@Autowired
	SupplierDaoI supplierDao;
	@Autowired 
	RestTemplate restTemplate;
	@Autowired
	SupplierOrderProductsServiceI supplierOrderProductsServiceI;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Transactional

	public List<Supplier> get() {
		// TODO Auto-generated method stub
		 
		return supplierDao.get();
	}

	@Transactional

	public Supplier getSupplierOrderById(int id) {
		// TODO Auto-generated method stub
		Supplier sup = supplierDao.getSupplierOrderById(id);
		return sup;
	}

	@Transactional

	public Integer addSupplierOrder(Supplier supplier) {
		// TODO Auto-generated method stub\
		return supplierDao.addSupplierOrder(supplier);
		
	}


	@Transactional
	@Override
	public ResponseInventryOrder getAndCreateOrder(int locationId){
		ResponseInventryOrder response = new ResponseInventryOrder();
		Supplier sup = getByLocation(locationId);
	
			if(sup!=null && sup.getIsfullfilled()==0) {
				response.setSupplier(sup);
				response.setOrderProducts(supplierOrderProductsServiceI.getSupplierOrderProductsBySupplierOrder(sup.getId()));
				return response;
			}
		
		Supplier supp = new Supplier();
		supp.setIsfullfilled(0);
		supp.setStoreid(locationId);
		
		supp = getSupplierOrderById(addSupplierOrder(supp));
		
		List<SupplierOrderProducts> orderProducts = new ArrayList<>();
		String url = "http://localhost:8083/storeproducts/getStoreProductsByLocation?location="+locationId;
		StoreProducts[] objects= restTemplate.getForObject(url, StoreProducts[].class);
		for(int i=0;i<objects.length;i++) {
			SupplierOrderProducts supplierOrder = new SupplierOrderProducts();
			supplierOrder.setProduct(objects[i].getProduct());
			supplierOrder.setQuantity(objects[i].getRequiredquantity()-objects[i].getAvailablequantity());
			supplierOrder.setSupplierorderid(supp.getId());
			supplierOrderProductsServiceI.addSupplierOrderProducts(supplierOrder);
			orderProducts.add(supplierOrder);
		}
		response.setSupplier(supp);
		response.setOrderProducts(orderProducts);
		return response;
	}
	@Transactional
	public void completeOrder(int orderId,int location) {
		List<SupplierOrderProducts> orderProducts=supplierOrderProductsServiceI.getSupplierOrderProductsBySupplierOrder(orderId);
		for(SupplierOrderProducts orderProduct:orderProducts) {
			orderProduct.getProduct();
			String url = "http://localhost:8083/storeproducts/getStoreProductbyNameAndLocation?Name="+orderProduct.getProduct()+"&locationId="+location;
			System.out.println("THe url is  "+url);
			StoreProducts objects= restTemplate.getForObject(url, StoreProducts.class);
			objects.setAvailablequantity(objects.getAvailablequantity()+orderProduct.getQuantity());
			url = "http://localhost:8083/storeproducts/updateStoreProduct";
			restTemplate.postForObject(url, objects, String.class);
			System.out.println("Update od object done "+orderProduct);
		}
	}
	
	@Transactional
	public void updateSupplierOrder(Supplier supplier) {
		completeOrder(supplier.getId(),supplier.getStoreid());
		supplier.setIsfullfilled(1);
		supplierDao.updateSupplierOrder(supplier);
		System.out.println("Status updated object is "+supplier);
	}

	@Transactional

	public boolean deleteSupplierOrder(int id) {
		// TODO Auto-generated method stub
		return supplierDao.deleteSupplierOrder(id);
	}

	@Transactional

	public List<Supplier> get(int pagestart, int pageEnd) {
		// TODO Auto-generated method stub
		return supplierDao.get(pagestart, pageEnd);
	}

	@Transactional
	public Supplier getByLocation(int locationId){
		return supplierDao.getSupplierOrderByLocation(locationId);
	}

}
