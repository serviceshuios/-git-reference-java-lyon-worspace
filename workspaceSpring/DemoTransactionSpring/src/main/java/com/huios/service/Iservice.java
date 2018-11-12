package com.huios.service;

import com.huios.metier.Stock;
import com.huios.service.exceptions.ArticleNotFoundException;
import com.huios.service.exceptions.NotEnoughArticleException;
import com.huios.service.exceptions.QtyNegativeException;

public interface Iservice {
	public void sortArticleDuStock(int id, int qute) throws
	ArticleNotFoundException, QtyNegativeException, NotEnoughArticleException;
	
	public int getQtyEnStock(int id) throws ArticleNotFoundException; 
	
	public void ajouter(Stock c);
}
