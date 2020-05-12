package com.technocrats.order.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.SqlResultSetMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technocrats.order.beans.Invoice;
import com.technocrats.order.beans.Sales;
import com.technocrats.order.beans.StatisticsData;
@Repository
public interface InventroyDaoI extends JpaRepository<Invoice,Integer> {
	List<Invoice> findAll();
	Invoice saveAndFlush(Invoice invoice);
	Optional<Invoice> findById(Integer id);
	void deleteById(Integer id);
	@Query(value = "SELECT new com.technocrats.order.beans.StatisticsData(sum(t.totalprice) as totalprice,DATE_FORMAT(dataofsale , '%m/%d/%Y') as dataofsale) FROM Invoice t where dataofsale BETWEEN ?1 AND CURDATE()  and location = ?2  group by dataofsale order by dataofsale")
	List<StatisticsData> findSalesStatisticsWithData(String value,int locationId);
}
