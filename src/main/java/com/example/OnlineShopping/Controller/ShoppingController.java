package com.example.OnlineShopping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineShopping.Model.Category;
import com.example.OnlineShopping.Model.Order;
import com.example.OnlineShopping.Model.OrderItem;
import com.example.OnlineShopping.Model.Product;
import com.example.OnlineShopping.Model.Signup;
import com.example.OnlineShopping.Repo.CategoryRepo;
import com.example.OnlineShopping.Repo.OrderItemRepo;
import com.example.OnlineShopping.Repo.OrderRepo;
import com.example.OnlineShopping.Repo.ProductRepo;
import com.example.OnlineShopping.Repo.ShopRepo;


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
	private OrderItemRepo orderitemRepo;
	
	@Autowired
	private OrderRepo orderRepo;
	
	
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
	 @PostMapping("/addproduct")
		public ResponseEntity<?> addProduct(@RequestBody Product product){
//		 Category ct=categoryRepo.findByName(product.getCategoryname());
//		 product.setCategoryname(ct);
		 System.out.println("===Category Name==="+product.getCategoryname());
			Product product1 = productRepo.saveAndFlush(product);
					return ResponseEntity.status(HttpStatus.OK)
							.body(product1);
		}

//	 @GetMapping("/getproductname{productname}")
//	 public ResponseEntity<?> findByProductname(@PathVariable String productname){
//			List<Product> product1 = productRepo.findByName(productname);
//					return ResponseEntity.status(HttpStatus.OK)
//							.body(product1);
//		}
//	 
	 
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
//	 
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
	 @PostMapping("/addorderitem")
		public ResponseEntity<?> addOrderItem(@RequestBody OrderItem orderitem){
		 OrderItem orderitem1 = orderitemRepo.saveAndFlush(orderitem);
					return ResponseEntity.status(HttpStatus.OK)
							.body(orderitem1);
		}
	 @PostMapping("/addorder")
		public ResponseEntity<?> addOrder(@RequestBody Order order){
		 Order order1 = orderRepo.saveAndFlush(order);
					return ResponseEntity.status(HttpStatus.OK)
							.body(order1);
		}
}

