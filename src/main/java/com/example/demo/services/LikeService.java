package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Entry;
import com.example.demo.model.Like;
import com.example.demo.model.User;
import com.example.demo.repository.LikeRepository;

@Service
public class LikeService {

	@Autowired
	LikeRepository likeRepository;

	public long likeCount(Entry entry, boolean rating) {

		return likeRepository.countByEntryAndRating(entry, rating);

	}
	
	public ArrayList<Like> getLastLike(Entry entry, User user) {
		
		ArrayList<Like> likeList = (ArrayList<Like>) likeRepository.findByEntryAndUser(entry, user);
		
		if(likeList.size()==0)
			likeList = null;
		
		
		return likeList;

	}

	/***
	 * 
	 * @param user
	 * @param entry
	 * @param rating
	 */
	public Boolean likeadd(User user, Entry entry, boolean rating) {
		// SAYFADAN GELEN USER ve entrye göre veritabanında arama yapılır//
		
		Boolean last = null;
		
		if (likeRepository.countByEntryAndUser(entry, user) == 0)// eger böyle bir like yok ise yeni bir like
																	// olusturulup eklenir
		{
			Like like = new Like();
			like.setEntry(entry);
			like.setRating(rating);
			entry.setTotal(entry.getTotal()+1);
			like.setUser(user);
			likeRepository.save(like);
		} else {
			Like like = likeRepository.findByEntryAndUser(entry, user).get(0);
			if (like.isRating() == rating)// eger mevcut like sayfadan gelen değere eşit ise likeı sileriz
			{	
				like.setUser(null);
				entry.setTotal(entry.getTotal()-1);
				like.setEntry(null);
				likeRepository.save(like);
				likeRepository.delete(like);
			} else {// eger gelen like değeri farklı ise mevcut olanı silip yerine yenisini ekleriz
				like.setUser(null);

				like.setEntry(null);
				likeRepository.save(like);
				likeRepository.delete(like);
				likeRepository.delete(like);
				Like like1 = new Like();
				like1.setEntry(entry);
				like1.setRating(rating);
				like1.setUser(user);
				
				likeRepository.save(like1);
			}
		}
		
		return  null;

	}

}
