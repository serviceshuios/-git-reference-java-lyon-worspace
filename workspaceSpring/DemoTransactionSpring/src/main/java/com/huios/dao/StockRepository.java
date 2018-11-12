package com.huios.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.huios.metier.Stock;



/*@Transactional(rollbackFor={ArticleNotFoundException.class,
QtyNegativeException.class,NotEnoughArticleException.class})*/
@Transactional
public interface StockRepository extends JpaRepository<Stock, Integer>{
	@Modifying
	@Query("update Stock s set s.quantite=s.quantite-?2 where s.id=?1")
	void sortArticleDuStock(int id,int qute);
	

}