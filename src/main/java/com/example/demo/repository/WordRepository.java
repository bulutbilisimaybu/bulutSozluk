package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
	ArrayList<Word> findByWordIgnoreCaseContaining(String word);
}
