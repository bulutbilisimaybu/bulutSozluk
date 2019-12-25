package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sharing;
import com.example.demo.repository.SharingRepository;

@Service
public class SharingService {

	@Autowired
	SharingRepository sharingRepository;

	public Sharing getSharing(long id) {

		Optional<Sharing> sharing = sharingRepository.findById(id);
		if (sharing.isPresent() == false) {
			return null;
		} else {
			return sharing.get();
		}

		
	}
	
	public int sharingtitlecount(long id) {
		Optional<Sharing> st =sharingRepository.findById(id);
		
		if(st.isPresent()==false) {
			return 0;
		}
		else {
			
			return st.get().getEntryList().size();
		}
	}
	
	public ArrayList<Sharing> getSharingByContent(String title){
		ArrayList<Sharing> sharingList=sharingRepository.findTop10ByTitleIgnoreCaseContaining(title);
		return sharingList;
	}

}
