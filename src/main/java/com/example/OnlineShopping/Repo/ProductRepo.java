package com.example.OnlineShopping.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.OnlineShopping.Model.Product;
import com.example.OnlineShopping.Model.Signup;



@Repository
public interface ProductRepo  extends JpaRepository<Product, Integer> {
//	@Query(value = "Select * from Products Where productname = :productname", nativeQuery = true)
//	  List<Product> findByName(String productname);
}

