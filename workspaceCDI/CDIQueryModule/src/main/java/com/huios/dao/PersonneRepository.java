package com.huios.dao;

import java.util.List;

import com.ctp.cdi.query.Dao;
import com.ctp.cdi.query.EntityDao;
import com.ctp.cdi.query.Query;
import com.huios.metier.Personne;

//@Dao
public interface PersonneRepository extends EntityDao<Personne, Long> {
	 List<Personne> findByNameLikeAndAgeBetween(String name, 
             int minAge, int maxAge);
	 
	   @Query("select count(p) from Person p where p.age > ?1")
	    Long countAllOlderThan(int minAge);
}
