package com.example.OnlineShopping.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.OnlineShopping.Model.AddCart;



@Repository
public interface CartRepo  extends JpaRepository<AddCart, Integer> {
	
}