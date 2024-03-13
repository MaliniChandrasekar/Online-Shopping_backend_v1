package com.example.OnlineShopping.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.OnlineShopping.Model.Order;


@Repository
public interface OrderRepo  extends JpaRepository<Order, Integer> {
	
}

