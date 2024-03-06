package com.example.OnlineShopping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineShopping.Model.Signup;
import com.example.OnlineShopping.Repo.SignupRepo;


@RestController
@RequestMapping("/signup")
@CrossOrigin("http://localhost:3001")
public class ShoppingController {
	@Autowired
	private SignupRepo signupRepo;
	
	@PostMapping("/add")
	public ResponseEntity<?> signUp(@RequestBody Signup signup){
		Signup sign = signupRepo.saveAndFlush(signup);
				return ResponseEntity.status(HttpStatus.OK)
						.body(sign);
	}
	
	 @GetMapping("/check")
	    public ResponseEntity<?> StudentId(@RequestParam String email, @RequestParam String password){
	        List<Signup> sign = signupRepo.findBy(email, password); 
	        return ResponseEntity.status(HttpStatus.OK).body(sign);
	    }

}

