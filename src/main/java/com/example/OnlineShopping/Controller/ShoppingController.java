package com.example.OnlineShopping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineShopping.Model.AddCart;
import com.example.OnlineShopping.Model.Category;
import com.example.OnlineShopping.Model.Product;
import com.example.OnlineShopping.Model.Signup;
import com.example.OnlineShopping.Model.Wish;
import com.example.OnlineShopping.Repo.CartRepo;
import com.example.OnlineShopping.Repo.CategoryRepo;
import com.example.OnlineShopping.Repo.ProductRepo;
import com.example.OnlineShopping.Repo.ShopRepo;
import com.example.OnlineShopping.Repo.WishRepo;


@RestController
@RequestMapping("/shop")
public class ShoppingController {
	@Autowired
	private ShopRepo shopRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private WishRepo wishRepo;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> signUp(@RequestBody Signup signup){
		signup.setRole("user");
		Signup sign = shopRepo.saveAndFlush(signup);
				return ResponseEntity.status(HttpStatus.OK)
						.body(sign);
	}
	 @GetMapping("/getcustomer")
	 public ResponseEntity<?> getcustomer(){
			List<Signup> signup = shopRepo.findAll();
					return ResponseEntity.status(HttpStatus.OK)
							.body(signup);
		}
	
	 @GetMapping("/check")
	    public ResponseEntity<?> StudentId(@RequestParam String email, @RequestParam String password){
	        Signup sign = shopRepo.findBy(email, password); 
	        return ResponseEntity.status(HttpStatus.OK).body(sign);
	    }
	 
	 @DeleteMapping("/deleteuser/{signupid}")
		public ResponseEntity<?> deleteuser(@PathVariable int signupid){
		 Signup signup1 = shopRepo.findById(signupid).get();
			shopRepo.delete(signup1);
			return ResponseEntity.status(HttpStatus.OK)
					.body(signup1);
		}

	 @GetMapping("/furniture/{categoryname}")
	    public ResponseEntity<?> getFurniture(@PathVariable String categoryname){
	        List<Product> product1 = productRepo.findByName(categoryname); 
	        return ResponseEntity.status(HttpStatus.OK).body(product1);
	    }
	 @PostMapping("/addproduct")
		public ResponseEntity<?> addProduct(@RequestBody Product product){
			Product product1 = productRepo.saveAndFlush(product);
					return ResponseEntity.status(HttpStatus.OK)
							.body(product1);
		}

	 @PostMapping("/addcart")
		public ResponseEntity<?> addCart(@RequestBody AddCart addcart){
			AddCart add = cartRepo.saveAndFlush(addcart);
					return ResponseEntity.status(HttpStatus.OK)
							.body(add);
		}
	 @GetMapping("/getcart")
	 public ResponseEntity<?> getcart(){
			List<AddCart> add = cartRepo.findAll();
					return ResponseEntity.status(HttpStatus.OK)
							.body(add);
		}
	 @PostMapping("/addwish")
		public ResponseEntity<?> addWish(@RequestBody Wish wish){
			Wish wish1 = wishRepo.saveAndFlush(wish);
					return ResponseEntity.status(HttpStatus.OK)
							.body(wish1);
		}
	 @GetMapping("/getwish")
	 public ResponseEntity<?> getWish(){
			List<Wish> wish = wishRepo.findAll();
					return ResponseEntity.status(HttpStatus.OK)
							.body(wish);
		}
	 @DeleteMapping("/deletewish/{wishid}")
		public ResponseEntity<?> deleteWish(@PathVariable int wishid){
		 Wish wish = wishRepo.findById(wishid).get();
			wishRepo.delete(wish);
			return ResponseEntity.status(HttpStatus.OK)
					.body(wish);
		}

	 @GetMapping("/getproduct")
	 public ResponseEntity<?> getproduct(){
			List<Product> product = productRepo.findAll();
					return ResponseEntity.status(HttpStatus.OK)
							.body(product);
		}
	 
	 @PutMapping("/updateproduct/{productid}")
		public ResponseEntity<?> updateStudent(@PathVariable int productid,@RequestBody Product product){
			
		 Product product1 = productRepo.findById(productid).orElse(null);
		 if (product1 == null) {
	            return null; 
	        }
		 product1.setCategoryname(product.getCategoryname());
		 product1.setDescription(product.getDescription());
		 product1.setImage(product.getImage());
		 product1.setPrice(product.getPrice());
		 product1.setProductname(product.getProductname());
		 Product savedEntity = productRepo.save(product1);
		        return ResponseEntity.status(HttpStatus.OK)
						.body(savedEntity);
			
		}
	 
	 @PutMapping("/updateuser/{signupid}")
	 public ResponseEntity<?> updateUser(@PathVariable int signupid, @RequestBody Signup signup) {
	     Signup signup1 = shopRepo.findById(signupid).orElse(null);
	     if (signup1 == null) {
	         return ResponseEntity.notFound().build(); 
	     }
	     signup1.setFirstname(signup.getFirstname());    
	     signup1.setLastname(signup.getLastname());
	     signup1.setCity(signup.getCity());
	     signup1.setEmail(signup.getEmail());
	     signup1.setPassword(signup.getPassword());
	     
	     Signup updatedSignup = shopRepo.save(signup1);
	     return ResponseEntity.ok(updatedSignup); 
	 }
	 
	 @DeleteMapping("/deleteproduct/{productid}")
		public ResponseEntity<?> deleteProduct(@PathVariable int productid){
		 Product product = productRepo.findById(productid).get();
			productRepo.delete(product);
			return ResponseEntity.status(HttpStatus.OK)
					.body(product);
		}
	 
	 @DeleteMapping("/deletecart/{cartid}")
		public ResponseEntity<?> deleteCart(@PathVariable int cartid){
		 AddCart add = cartRepo.findById(cartid).get();
			cartRepo.delete(add);
			return ResponseEntity.status(HttpStatus.OK)
					.body(add);
		}


	 @PostMapping("/addcategory")
		public ResponseEntity<?> addcategory(@RequestBody Category category){
		 Category category1= categoryRepo.saveAndFlush(category);
					return ResponseEntity.status(HttpStatus.OK)
							.body(category1);
		}
	 @GetMapping("/getcategory")
	 public ResponseEntity<?> getcategory(){
			List<Category> category = categoryRepo.findAll();
					return ResponseEntity.status(HttpStatus.OK)
							.body(category);
		}
	
}

