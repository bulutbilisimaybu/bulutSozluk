package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Advertising;
import com.example.demo.model.Category;
import com.example.demo.model.Entry;
import com.example.demo.model.Like;
import com.example.demo.model.Sharing;
import com.example.demo.model.User;
import com.example.demo.repository.AdvertisingRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.EntryRepository;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.SharingRepository;
import com.example.demo.repository.UserRepository;

@Service
public class AddFunction
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
	SharingService sharingservice;
	
	
	public void categoryAdd()
	{
		ArrayList<Category> categoryList=new ArrayList<Category>();
		
		Category cat1=new Category();
		cat1.setCategoryName("debe");
		
		Category cat2=new Category();
		cat2.setCategoryName("sorunsallar");
		
		Category cat3=new Category();
		cat3.setCategoryName("spor");
		
		Category cat4=new Category();
		cat4.setCategoryName("ilişkiler");
		
		Category cat5=new Category();
		cat5.setCategoryName("siyaset");
		
		Category cat6=new Category();
		cat6.setCategoryName("...");
		
		
		
		categoryList.add(cat1);
		categoryList.add(cat2);
		categoryList.add(cat3);
		categoryList.add(cat4);
		categoryList.add(cat5);
		categoryList.add(cat6);
		
		
		categoryRepository.saveAll(categoryList);

		
	}
	
	
	public void sharingAdd()
	{
		ArrayList<Sharing> sharingList=new ArrayList<Sharing>();
		Sharing sharing1=new Sharing();
		sharing1.setTitle("propolis");
		sharing1.setCategory(categoryRepository.findById(1L).get());
		sharing1.setDate("10-12-2019");

		Sharing sharing2=new Sharing();
		sharing2.setTitle("acun ılıcalı");
		sharing2.setCategory(categoryRepository.findById(1L).get());
		sharing2.setDate("9-12-2019");

		Sharing sharing3=new Sharing();
		sharing3.setTitle("okul sırası ile drift yapan liseli");
		sharing3.setCategory(categoryRepository.findById(2L).get());
		sharing3.setDate("8-12-2019");

		Sharing sharing4=new Sharing();
		sharing4.setTitle("suruç'ta doktora atılan dayak");
		sharing4.setCategory(categoryRepository.findById(2L).get());
		sharing4.setDate("7-12-2019");

		Sharing sharing5=new Sharing();
		sharing5.setTitle("1 milyon 605 bin euro'yu almadan ayrılmam");
		sharing5.setCategory(categoryRepository.findById(2L).get());
		sharing5.setDate("6-12-2019");

		sharingList.add(sharing1);
		sharingList.add(sharing2);
		sharingList.add(sharing3);
		sharingList.add(sharing4);
		sharingList.add(sharing5);
		
		sharingRepository.saveAll(sharingList);
		

	}
	public void advertisingAdd()
	{
		ArrayList<Advertising> advertisingList=new ArrayList<Advertising>();
		Advertising advertising1=new Advertising();
		advertising1.setImagePath("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTmMEX2R5MeN8soyyU-flRkwWmGt4QGLrmQAKQ8pRI-MIk3SUiA");
		
		Advertising advertising2=new Advertising();
		advertising2.setImagePath("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS3H8NpSrX4X6zHIQ33uGrTe23QAgxn6jyl_ss4icCjTkxO2JGx");
		
		Advertising advertising3=new Advertising();
		advertising3.setImagePath("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSSOwH2i9NrNn2bWoRNK5AkpiyZqhzwrFs5FhNGWFu56juZ5r9q");
		
		advertisingList.add(advertising1);
		advertisingList.add(advertising2);
		advertisingList.add(advertising3);
		
		advertisingRepository.saveAll(advertisingList);
		}
	
	public void entryAdd()
	{
		ArrayList<Entry> entryList=new ArrayList<Entry>();
		
		Entry entry1=new Entry();
		entry1.setContent("Çok mükemmel");
		entry1.setSharing(sharingRepository.findById(1L).get());
		entry1.setDate("19.12.2019");
		
		
		Entry entry2=new Entry();
		entry2.setContent("Çok kötü");
		entry2.setSharing(sharingRepository.findById(1L).get());
		entry2.setDate("18.12.2019");
		
		
		Entry entry3=new Entry();
		entry3.setContent("Orta");
		entry3.setSharing(sharingRepository.findById(2L).get());
		entry3.setDate("17.12.2019");
	
		
		Entry entry4=new Entry();
		entry4.setContent("Fena Değil");
		entry4.setSharing(sharingRepository.findById(2L).get());
		entry4.setDate("11.12.2019");
		
		Entry entry5=new Entry();
		entry5.setContent("Good");
		entry5.setSharing(sharingRepository.findById(5L).get());
		entry5.setDate("13.12.2019");
		Entry entry6=new Entry();
		entry6.setContent("Fena Değil");
		entry6.setSharing(sharingRepository.findById(3L).get());
		entry6.setDate("11.12.2019");
		
		Entry entry7=new Entry();
		entry7.setContent("Good");
		entry7.setSharing(sharingRepository.findById(4L).get());
		entry7.setDate("10.12.2019");
		
		entryList.add(entry1);
		entryList.add(entry2);
		entryList.add(entry3);
		entryList.add(entry4);
		entryList.add(entry5);
		entryList.add(entry6);
		entryList.add(entry7);
		
		entryRepository.saveAll(entryList);
		

		
	}
	public void userAdd()
	{
		ArrayList<User> userList=new ArrayList<User>();
		
		User user1=new User();
		user1.setName("Burak");
		user1.setSurname("Göçer");
		user1.setGender("Erkek");
		user1.setMail("burkgocer@outlook.com");
		user1.setNickname("burkgocer");
		user1.setPassword("root");
		
		User user2=new User();
		user2.setName("Ali Abbas");
		user2.setSurname("Tatlı");
		user2.setGender("Erkek");
		user2.setMail("aliabbastatli@yadex.com");
		user2.setNickname("aliabbastatli");
		user2.setPassword("root");
		
		User user3=new User();
		user3.setName("Nurettin Eren");
		user3.setSurname("İnan");
		user3.setGender("Erkek");
		user3.setMail("ereninan@outlook.com");
		user3.setNickname("ereninann");
		user3.setPassword("root");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		userRepository.saveAll(userList);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void likeAdd()
	{
		ArrayList<Like> likeList=new ArrayList<Like>();
		
		Like like1=new Like();
		like1.setRating(true);
		like1.setEntry(entryRepository.findById(1L).get());
		like1.setUser(userRepository.findById(1L).get());
		likeRepository.save(like1);
		
		Like like2=new Like();
		like2.setRating(true);
		like2.setEntry(entryRepository.findById(1L).get());
		like2.setUser(userRepository.findById(1L).get());
		likeRepository.save(like2);
		
		
		Like like3=new Like();
		like3.setRating(false);
		like3.setEntry(entryRepository.findById(1L).get());
		like3.setUser(userRepository.findById(1L).get());
		likeRepository.save(like3);
		
		
		Like like4=new Like();
		like4.setRating(true);
		like4.setEntry(entryRepository.findById(2L).get());
		like4.setUser(userRepository.findById(2L).get());
		likeRepository.save(like4);
		
		
		Like like5=new Like();
		like5.setRating(false);
		like5.setEntry(entryRepository.findById(2L).get());
		like5.setUser(userRepository.findById(2L).get());
		likeRepository.save(like5);
		
		
		likeList.add(like1);
		likeList.add(like2);
		likeList.add(like3);
		likeList.add(like4);
		likeList.add(like5);
		
		
		
		
	}

}
