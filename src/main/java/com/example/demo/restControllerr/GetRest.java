package com.example.demo.restControllerr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Entry;
import com.example.demo.model.Sharing;
import com.example.demo.model.User;
import com.example.demo.model.api.EntryAPI;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.GetFunction;
import com.example.demo.services.LikeService;
import com.example.demo.services.UserService;

@RestController
public class GetRest 
{
	
    @Autowired
    private UserService userService;
    
	@Autowired
	GetFunction fonksiyon;
	
	@Autowired
	LikeService likeService;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/getCategory")
	public ResponseEntity<Object> getEmployee(@RequestParam Long id) {

		return new ResponseEntity<>(fonksiyon.categoryGet(id), HttpStatus.OK);
	}
	@GetMapping("/entrycontent")
	public ResponseEntity<Object> getentrycontent(@RequestParam Long id) {

		return new ResponseEntity<>(fonksiyon.categoryGet(id), HttpStatus.OK);
	}
	@GetMapping("/getEntryOfSharing")
	public ResponseEntity<Object> getEntryOfSharing(@RequestParam Long id) {
		List<Entry> entryList = fonksiyon.entryOfSharingGet(id);
	
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByMail(auth.getName());
		ArrayList<EntryAPI> entryApiList = new ArrayList<>();

		for (Entry entry : entryList) {

			EntryAPI entryApi = new EntryAPI();
			entryApi.setEntry(entry.getContent());
			entryApi.setTitle(entry.getSharing().getTitle());
			entryApi.setLikeCount(likeService.likeCount(entry, true));
			entryApi.setDislikeCount(likeService.likeCount(entry, false));
			entryApi.setPostId(entry.getId());
			entryApi.setDate(entry.getDate());
			entryApi.setNickname(entry.getUser().getMail());

			entryApi.setLikecontrol(likeService.getLastLike(entry, user));
			entryApiList.add(entryApi);
			
		}

		
		
		return new ResponseEntity<>(entryApiList, HttpStatus.OK);
	}
	
	@GetMapping("/getSharingOfCategory")
	public ResponseEntity<Object>getSharingOfCategory(@RequestParam Long id) {
		List<Sharing> sharingList = fonksiyon.sharingOfCategoryGet(id);
		return new ResponseEntity<>(sharingList, HttpStatus.OK);
	}
	
	@GetMapping("/getSharingOfCategoryss")
	public ResponseEntity<Object>getSharingOfCategorys(@RequestParam Long id) {
		List<Sharing> sharingList = fonksiyon.sharingOfCategoryGet(id);
		return new ResponseEntity<>(sharingList, HttpStatus.OK);
	}
	
	@GetMapping("/getentrypost")
	public ResponseEntity<Object>getentrypost(@RequestParam Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByMail(auth.getName());
		Entry entry = fonksiyon.getentrypost(id);		
		EntryAPI entryApi = new EntryAPI();
		entryApi.setEntry(entry.getContent());
		entryApi.setTitle(entry.getSharing().getTitle());
		entryApi.setLikeCount(likeService.likeCount(entry, true));
		entryApi.setDislikeCount(likeService.likeCount(entry, false));
		entryApi.setPostId(entry.getId());
		entryApi.setDate(entry.getDate());
		entryApi.setNickname(entry.getUser().getMail());
		entryApi.setLikecontrol(likeService.getLastLike(entry, user));
		return new ResponseEntity<>(entryApi, HttpStatus.OK);
	}
	
	
	
	
	


}
