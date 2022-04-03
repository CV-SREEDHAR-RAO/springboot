package com.sprotyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprotyshoes.model.Userreg;

@Repository
public interface Userrepository extends JpaRepository<Userreg, Integer>{
	
	@Query(value = "select * from Userreg s where s.username like %:keyword%", nativeQuery = true)
	 List<Userreg>findByKeyword(@Param("keyword") String keyword);

}




