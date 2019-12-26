package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Conjunction;
import com.example.demo.model.Word;
import com.example.demo.model.api.EntryAPI;
import com.example.demo.repository.ConjunctionRepository;
import com.example.demo.repository.WordRepository;


@RestController
public class AdminController {
	@Autowired
	WordRepository wordRepository;
	@Autowired
	ConjunctionRepository conjuctionRepository;
	
	
	
	
	@PostMapping("/addword")
	public ResponseEntity<Object> postWord(@RequestBody Word word)
	{
		wordRepository.save(word);
		

		return new ResponseEntity<Object>("Başarılı", HttpStatus.OK);

	}
	@PostMapping("/addconjuction")
	public ResponseEntity<Object> postConjuction(@RequestBody Conjunction conjuction)
	{
		conjuctionRepository.save(conjuction);
		

		return new ResponseEntity<Object>("Başarılı", HttpStatus.OK);

	}
	
	
	

}
