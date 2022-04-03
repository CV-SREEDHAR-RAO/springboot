package com.sprotyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sprotyshoes.model.Productcat;

@Repository
public interface Productrepository extends JpaRepository<Productcat, Integer> {

}
