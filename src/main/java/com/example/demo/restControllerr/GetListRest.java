package com.example.demo.restControllerr;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Word;
import com.example.demo.repository.WordRepository;
import com.example.demo.services.EntryServices;
import com.example.demo.services.ListFunction;
import com.example.demo.services.SharingService;
import com.example.demo.services.WordService;

@RestController
public class GetListRest {
	@Autowired
	ListFunction fonksiyon;
	@Autowired
	EntryServices entryServices;
	@Autowired
	SharingService sharingServices;
	@Autowired
	WordService wordService;

	@GetMapping("/categoryList")
	public ResponseEntity<Object> categoryList() {
		return new ResponseEntity<>(fonksiyon.categoryListGet(), HttpStatus.OK);
	}

	@GetMapping("/sharingList")
	public ResponseEntity<Object> sharingList() {
		return new ResponseEntity<>(fonksiyon.sharingListGet(), HttpStatus.OK);
	}

	@GetMapping("/userList")
	public ResponseEntity<Object> userList() {
		return new ResponseEntity<>(fonksiyon.userListGet(), HttpStatus.OK);
	}

	@GetMapping("/entryList")
	public ResponseEntity<Object> entryList() {
		return new ResponseEntity<>(fonksiyon.entryListGet(), HttpStatus.OK);
	}

	@GetMapping("/entryListByContent")
	public ResponseEntity<Object> entryListByContent(@RequestParam String content) {
		return new ResponseEntity<>(entryServices.getEntryByContent(content), HttpStatus.OK);
	}

	@GetMapping("/SharingListByTitle")
	public ResponseEntity<Object> sharingListByTitle(@RequestParam String title) {
		return new ResponseEntity<>(sharingServices.getSharingByContent(title), HttpStatus.OK);
	}

	@GetMapping("/SharingCount")
	public ResponseEntity<Object> sharingcount(@RequestParam long id) {
		return new ResponseEntity<>(sharingServices.sharingtitlecount(id), HttpStatus.OK);
	}

	@GetMapping("/getWord")
	public ResponseEntity<Object> getWord( ) {
		
		return new ResponseEntity<>(wordService.rndWord(), HttpStatus.OK);

	}

}
