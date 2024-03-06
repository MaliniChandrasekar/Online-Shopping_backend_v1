package com.example.OnlineShopping.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.OnlineShopping.Model.Signup;






@Repository
public interface SignupRepo  extends JpaRepository<Signup, Integer> {
	@Query(value = "Select * from SignUp Where email = :email AND password = :password", nativeQuery = true)
    List<Signup> findBy(String email, String password);
}
