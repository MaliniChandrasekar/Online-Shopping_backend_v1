package com.example.OnlineShopping.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.OnlineShopping.Model.Wish;


@Repository
public interface WishRepo  extends JpaRepository<Wish, Integer> {
	
}
