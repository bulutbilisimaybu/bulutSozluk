package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Conjunction;
import com.example.demo.model.Entry;
import com.example.demo.model.Sharing;
import com.example.demo.model.User;
import com.example.demo.model.Word;
import com.example.demo.model.api.EntryAPI;
import com.example.demo.repository.AdvertisingRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ConjunctionRepository;
import com.example.demo.repository.EntryRepository;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.SharingRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WordRepository;

@Service
public class ListFunction {
	@Autowired
	WordRepository wordRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ConjunctionRepository conjuctionRepository;

	@Autowired
	SharingRepository sharingRepository;

	@Autowired
	AdvertisingRepository advertisingRepository;

    @Autowired
    private UserService userService;
    
	@Autowired
	EntryRepository entryRepository;

	@Autowired
	LikeRepository likeRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	LikeService likeService;

	public ArrayList<Category> categoryListGet() {
		return (ArrayList<Category>) categoryRepository.findAll();
	}

	public ArrayList<Sharing> sharingListGet() {
		return (ArrayList<Sharing>) sharingRepository.findAll();
	}

	public ArrayList<User> userListGet() {
		return (ArrayList<User>) userRepository.findAll();
	}

	public ArrayList<EntryAPI> entryListGet() {

		ArrayList<Entry> entryList = (ArrayList<Entry>) entryRepository.findAll();

		ArrayList<EntryAPI> entryApiList = new ArrayList<>();

		for (Entry entry : entryList) {

			EntryAPI entryApi = new EntryAPI();
			entryApi.setEntry(entry.getContent());
			entryApi.setTitle(entry.getSharing().getTitle());
			entryApi.setLikeCount(likeService.likeCount(entry, true));
			entryApi.setDislikeCount(likeService.likeCount(entry, false));
			entryApi.setPostId(entry.getId());
			entryApi.setDate(entry.getDate());
			entryApi.setNickname(entry.getUser().getNickname());
			entryApiList.add(entryApi);

		}

		return entryApiList;
	}
	
	public ArrayList<Word> wordListGet() {
		return (ArrayList<Word>) wordRepository.findAll();
	}
	public ArrayList<Conjunction> conjuctionListGet() {
		return (ArrayList<Conjunction>) conjuctionRepository.findAll();
	}
	
	public ArrayList<Entry> favoriteentrylist() 
	{
		return(ArrayList<Entry>) entryRepository.findTop18ByOrderByTotalLikeDesc();
	
	}
}
