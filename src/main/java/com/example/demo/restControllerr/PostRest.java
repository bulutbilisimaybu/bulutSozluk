package com.example.demo.restControllerr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Conjunction;
import com.example.demo.model.Entry;
import com.example.demo.model.User;
import com.example.demo.model.Word;
import com.example.demo.model.api.EntryAPI;
import com.example.demo.model.api.LikeAPI;
import com.example.demo.repository.ConjunctionRepository;
import com.example.demo.repository.WordRepository;
import com.example.demo.services.EntryServices;
import com.example.demo.services.GetFunction;
import com.example.demo.services.LikeService;
import com.example.demo.services.UserService;

@RestController
public class PostRest {

	@Autowired
	EntryServices entryService;
	@Autowired
	ConjunctionRepository conjuctionRepository;

	@Autowired
	LikeService likeService;

	@Autowired
	UserService userService;
	@Autowired
	GetFunction function;
	@Autowired 
	WordRepository wordRepository;

	
	
	@PostMapping("/postEntry")
	public ResponseEntity<Object> postEntry(@RequestBody EntryAPI entry) {
		boolean deger=entryService.entryControl(entry);
		return new ResponseEntity<Object>(deger, HttpStatus.OK);

	}

	@PostMapping("/postLike")
	public ResponseEntity<Object> postLike(@RequestBody LikeAPI likeApi) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByMail(auth.getName());
		
		Entry entry = entryService.getEntry(likeApi.getEntryId());

		likeService.likeadd(user, entry, likeApi.isRating());

		EntryAPI entryAPI = new EntryAPI();

		entryAPI.setEntry(entry.getContent());
		entryAPI.setTitle(entry.getSharing().getTitle());
		entryAPI.setLikeCount(likeService.likeCount(entry, true));
		entryAPI.setDislikeCount(likeService.likeCount(entry, false));

		if (likeService.getLastLike(entry, user) != null)
			entryAPI.setLastLike(likeService.getLastLike(entry, user).get(0).isRating());
		else
			entryAPI.setLastLike(null);

		return new ResponseEntity<Object>(entryAPI, HttpStatus.OK);
	}
	@PostMapping("/postWord")
	public ResponseEntity<Object> postWord(@RequestBody Word word) {
		
		wordRepository.delete(word);
		

		return new ResponseEntity<Object>(wordRepository.findAll(), HttpStatus.OK);

	}
	@PostMapping("/postConjuction")
	public ResponseEntity<Object> postConjuction(@RequestBody Conjunction conjuction) {
		
		conjuctionRepository.delete(conjuction);
		

		return new ResponseEntity<Object>(conjuctionRepository.findAll(), HttpStatus.OK);

	}

}
