package com.example.OnlineShopping.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.OnlineShopping.Model.Product;
import com.example.OnlineShopping.Repo.ProductRepo;

// Annotation 
@RestController
@RequestMapping("/file")
public class FileController {
	@Autowired
	private Environment env;
	@Autowired
	private ProductRepo productRepo;
	
//	 @PostMapping("/upload")
//	    public void uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
//	        Product imageEntity = new Product();
//	        imageEntity.setImage(file.getBytes());
//	        productRepo.save(imageEntity);
//	    }

	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadedFile) {
		if (uploadedFile.isEmpty()) {
			return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
		}
		try {

			byte[] bytes = uploadedFile.getBytes();

			UUID uuid = UUID.randomUUID();
//			String uploadsLocation = env.getProperty("resource.uploads");
			String uploadsLocation = "E:\\OnlineShopping\\OnlineShopping\\src\\main\\resources\\Uploads\\";
			String fileLocation = uploadsLocation + uuid + uploadedFile.getOriginalFilename();
			Path path = Paths.get(fileLocation);
			Files.write(path, bytes);

			File file = new File(fileLocation);
			return ResponseEntity.status(HttpStatus.OK).body(file.getName());

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());

		}
		
		
		
	}
	
	@PostMapping("/songupload")
    public ResponseEntity<String> uploadAudioFile(@RequestParam("file") MultipartFile audioFile) {
        if (audioFile.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file.");
        }

        try {
            // Generate a unique ID for the file
            UUID uuid = UUID.randomUUID();
//            String uploadsLocation = "E:\\OnlineShopping\\OnlineShopping\\src\\main\\resources\\Uploads\\";
            String fileName = uuid.toString() + "_" + audioFile.getOriginalFilename();
            MultipartConfigFactory factory = new MultipartConfigFactory();
            factory.setLocation("E:\\OnlineShopping\\OnlineShopping\\src\\main\\resources\\Uploads\\audio");
            // Save the file to a directory or database
            // You can save the audioFile bytes to a database here

            return ResponseEntity.ok().body("File uploaded successfully: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file: " + e.getMessage());
        }
    }
}

