package com.example.demo.services;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Word;
import com.example.demo.repository.WordRepository;

@Service
public class WordService {
	@Autowired
	WordRepository wordRepository;

	public ArrayList<Word> rndWord() {
		ArrayList<Word> words = (ArrayList<Word>) wordRepository.findAll();
		ArrayList<Word> randWord = new ArrayList<>();
		Random rand = new Random();
		
		for (int i = 0; i < 7; i++) {

			int number = rand.nextInt(words.size());
			randWord.add(words.get(number));
			words.remove(number);

		}
		
		return randWord;
	}
	
	
}
