package day26;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SaleRepo extends JpaRepository<Sale, Integer> {
	// 1
	List<Sale> findAllByQtyBetween(int min, int max);
	
	// 2 
	List<Sale> findAllByProdid(int prodid);
	
	// 3 
	@Query("select s from day26.Sale s WHERE MONTH(s.transdate) = :month")
	List<Sale> saleByMonth (@Param("month") int month);
	
	// 4
	List<Sale> findAllByQtyAndProdid(int qty, int prodid);
	
	// 6
	Integer countSalesByProdid(int prodid);
	
	// 7
	@Query
	("select s.product.prodname as prodName, sum(s.qty) as sumQty from day26.Sale s group by prodName")
	List<ProductNameQty> productNameQtyList();
	
	// 8 
	@Query 
	("select count(s) from day26.Sale s where month(s.transdate) = :month and year(s.transdate) = :year")
	Integer countSalesByMonthAndYear(@Param("month") int month, 
									@Param("year") int year);
}