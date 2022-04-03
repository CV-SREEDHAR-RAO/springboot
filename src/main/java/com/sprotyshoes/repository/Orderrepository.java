package com.sprotyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprotyshoes.model.Userorder;
import com.sprotyshoes.model.Userreg;

@Repository
public interface Orderrepository extends JpaRepository<Userorder, Integer> {
	
	@Query(value = "select * from Userorder u where u.date like %:keyword% or u.prodcat like %:keyword%", nativeQuery = true)
	 List<Userorder>findbykeyword(@Param("keyword") String keyword);
	
}
