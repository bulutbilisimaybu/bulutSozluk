package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Entry;

@Repository
public interface EntryRepository  extends JpaRepository<Entry,Long>
{
	ArrayList<Entry> findTop10ByContentIgnoreCaseContaining(String content);


}
