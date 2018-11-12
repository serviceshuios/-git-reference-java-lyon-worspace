package com.huios.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.huios.metier.Stock;
import com.huios.service.exceptions.ArticleNotFoundException;
import com.huios.service.exceptions.NotEnoughArticleException;
import com.huios.service.exceptions.QtyNegativeException;




public interface StockRepository extends JpaRepository<Stock, Integer>{
	@Modifying
	@Query("update Stock s set s.quantite=s.quantite-?2 where s.id=?1")
	void sortArticleDuStock(int id,int qute) throws
	ArticleNotFoundException, QtyNegativeException, NotEnoughArticleException;
	

}
