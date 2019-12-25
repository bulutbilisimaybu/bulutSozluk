package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Entry;
import com.example.demo.model.Sharing;
import com.example.demo.model.User;
import com.example.demo.model.api.EntryAPI;
import com.example.demo.repository.AdvertisingRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.EntryRepository;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.SharingRepository;
import com.example.demo.repository.UserRepository;

@Service
public class ListFunction {
	@Autowired
	CategoryRepository categoryRepository;

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

}
