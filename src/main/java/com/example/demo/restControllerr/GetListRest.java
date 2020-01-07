package com.example.demo.restControllerr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.EntryRepository;
import com.example.demo.services.EntryServices;
import com.example.demo.services.ListFunction;
import com.example.demo.services.SharingService;

@RestController
public class GetListRest {
	@Autowired
	ListFunction fonksiyon;
	@Autowired
	EntryServices entryServices;
	@Autowired
	SharingService sharingServices;
	@GetMapping("/categoryList")
	public ResponseEntity<Object> categoryList() 
	{
		return new ResponseEntity<>(fonksiyon.categoryListGet(), HttpStatus.OK);
	}
	
	@GetMapping("/sharingList")
	public ResponseEntity<Object> sharingList() 
	{
		return new ResponseEntity<>(fonksiyon.sharingListGet(), HttpStatus.OK);
	}
	
	@GetMapping("/userList")
	public ResponseEntity<Object> userList() 
	{
		return new ResponseEntity<>(fonksiyon.userListGet(), HttpStatus.OK);
	}
	
	@GetMapping("/entryList")
	public ResponseEntity<Object> entryList() 
	{
		return new ResponseEntity<>(fonksiyon.entryListGet(), HttpStatus.OK);
	}
	
	@GetMapping("/entryListByContent")
	public ResponseEntity<Object> entryListByContent(@RequestParam String content) 
	{
		return new ResponseEntity<>(entryServices.getEntryByContent(content), HttpStatus.OK);
	}
	
	@GetMapping("/SharingListByTitle")
	public ResponseEntity<Object> sharingListByTitle(@RequestParam String title) 
	{
		return new ResponseEntity<>(sharingServices.getSharingByContent(title), HttpStatus.OK);
	}
	
	@GetMapping("/SharingCount")
	public ResponseEntity<Object> sharingcount(@RequestParam long id) 
	{
		return new ResponseEntity<>(sharingServices.sharingtitlecount(id), HttpStatus.OK);
	}
	
	@GetMapping("/wordList")
	public ResponseEntity<Object> wordList() 
	{
		return new ResponseEntity<>(fonksiyon.wordListGet(), HttpStatus.OK);
	}
	@GetMapping("/conjuctionList")
	public ResponseEntity<Object> conjuctionList() 
	{
		return new ResponseEntity<>(fonksiyon.conjuctionListGet(), HttpStatus.OK);
	}
	@Autowired
	EntryRepository repos;
	@GetMapping("/favoritentry")
	public ResponseEntity<Object> Favoriteentry() 
	{
		return new ResponseEntity<>(fonksiyon.favoriteentrylist(), HttpStatus.OK);
	}


}
