package day26.pubs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface TitleRepo extends JpaRepository<Title, String>, QueryByExampleExecutor<Title>{
	// 11
	@Query("select t from day26.pubs.Title t order by t.ytdSales desc")
	List<Title> topTitlesByYtdSales();
	
	// 12
	@Query("select t from day26.pubs.Title t order by t.publisher.city, t.price desc")
	List<Title> sortByPublisherCity();
	
	// 13
	@Query
	("select t.publisher.pubname as pubName, avg(t.price) from day26.pubs.Title t group by pubName")
	List<PubNameAvgPrice> pubNameAvgPriceList();
}