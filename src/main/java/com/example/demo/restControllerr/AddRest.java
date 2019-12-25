package com.example.demo.restControllerr;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.CategoryRepository;
import com.example.demo.services.AddFunction;



@RestController
public class AddRest 
{
	@Autowired
	AddFunction fonksiyon;
	
	@GetMapping("/categoryAdd")
	public ResponseEntity<Object> categoryAdd() 
	{
		fonksiyon.categoryAdd();
		return new ResponseEntity<>("Veriler Eklendi", HttpStatus.OK);
	}
	
	@GetMapping("/userAdd")
	public ResponseEntity<Object> userAdd() 
	{
		fonksiyon.userAdd();
		return new ResponseEntity<>("Veriler Eklendi", HttpStatus.OK);
	}
	
	@GetMapping("/sharingAdd")
	public ResponseEntity<Object> sharingAdd() 
	{
		fonksiyon.sharingAdd();
		return new ResponseEntity<>("Veriler Eklendi", HttpStatus.OK);
	}
	
	@GetMapping("/entryAdd")
	public ResponseEntity<Object> entryAdd() 
	{
		fonksiyon.entryAdd();
		return new ResponseEntity<>("Veriler Eklendi", HttpStatus.OK);
	}
	
	@GetMapping("/likeAdd")
	public ResponseEntity<Object> likeAdd() 
	{
		fonksiyon.likeAdd();
		return new ResponseEntity<>("Veriler Eklendi", HttpStatus.OK);
	}
	
	@GetMapping("/advertisingAdd")
	public ResponseEntity<Object> advertisingAdd() 
	{
		fonksiyon.advertisingAdd();
		return new ResponseEntity<>("Veriler Eklendi", HttpStatus.OK);
	}

}
