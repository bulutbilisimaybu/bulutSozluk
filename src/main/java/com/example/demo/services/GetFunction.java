package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Entry;
import com.example.demo.model.Sharing;
import com.example.demo.model.User;
import com.example.demo.model.Word;
import com.example.demo.repository.AdvertisingRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.EntryRepository;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.SharingRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WordRepository;

@Service
public class GetFunction 
{
	@Autowired
	 CategoryRepository categoryRepository;
	
	@Autowired
	SharingRepository sharingRepository;
	
	@Autowired
	AdvertisingRepository advertisingRepository;
	
	@Autowired
	EntryRepository entryRepository;
	
	@Autowired
	LikeRepository likeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	WordRepository wordRepository;
	
	public Category categoryGet(Long id)
	{
		Category category=categoryRepository.findById(id).get();
		return category;
		
	}
	
	public List<Entry> entryOfSharingGet(Long id)
	{
		Optional<Sharing> sharing=sharingRepository.findById(id);
		if(sharing.isPresent()==false)
		{
			return null;
		}
		else
		{
			return  sharing.get().getEntryList();
		}
		

		
	}
	
	public List<Sharing> sharingOfCategoryGet(Long id)
	{
		Optional<Category> category=categoryRepository.findById(id);
		if(category.isPresent()==false)
		{
			return null;
		}
		else
		{
			return  category.get().getSharingList();
		}
		

		
	}
	
	public Entry getentrypost(long id) {
		Optional<Entry> entry=entryRepository.findById(id);
		if(entry.isPresent()==false)
		{
			return null;
		}
		else
		{
			return  entry.get();
		}
	}
	
	public User getuser(long id) {
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent()==false)
		{
			return null;
		}
		else
		{
			return  user.get();
		}
	}
	
	public Word wordGet(Long id)
	{
		Word word=wordRepository.findById(id).get();
		return word;
		
	}
	
	
	
	

}
