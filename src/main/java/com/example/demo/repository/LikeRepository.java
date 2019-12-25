package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Entry;
import com.example.demo.model.Like;
import com.example.demo.model.User;

@Repository
public interface LikeRepository  extends JpaRepository<Like,Long>
{
	
	public long countByEntryAndRating(Entry entry, boolean rating);
	public long countByEntryAndUser(Entry entry, User user);
	public List<Like> findByEntryAndUser(Entry entry,User user);
	
}
