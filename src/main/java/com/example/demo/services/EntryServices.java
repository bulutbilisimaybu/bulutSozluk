package com.example.demo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Entry;
import com.example.demo.model.User;
import com.example.demo.model.api.EntryAPI;
import com.example.demo.repository.EntryRepository;
import com.example.demo.repository.WordRepository;

@Service
public class EntryServices {
	@Autowired
	EntryRepository entryRepository;
	
	@Autowired
	WordRepository wordRepository;
	@Autowired
	SharingService sharingService;

    @Autowired
    private UserService userService;
    
	public String sistemTarihiniGetir(String tarihFormati)
	{
	 Calendar takvim = Calendar.getInstance();
	 SimpleDateFormat sdf = new SimpleDateFormat(tarihFormati);
	 return sdf.format(takvim.getTime());
	}
	
	public void entrySave(String entry, long postId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByMail(auth.getName());
		Entry e = new Entry();

		e.setContent(entry);
		e.setSharing(sharingService.getSharing(postId));
		e.setDate(sistemTarihiniGetir("dd.MM.yyyy H:mm"));
		e.setUser(user);
		entryRepository.save(e);

	}
	
	
	public Entry getEntry(long id) {

		Optional<Entry> entry = entryRepository.findById(id);
		if (entry.isPresent() == false) {
			return null;
		} else {
			return entry.get();
		}

		
	}
	
	public ArrayList<Entry> getEntryByContent(String content){
		ArrayList<Entry> entryList=entryRepository.findTop10ByContentIgnoreCaseContaining(content);
		return entryList;
	}
	
	
	public boolean entryControl(EntryAPI entry) {
		String[] inputlist=entry.getEntry().split(" ");
		boolean deger=true;
		
		for (String a : inputlist) {
			if(wordRepository.findByWordIgnoreCaseContaining(a)==null)
			{
			deger=false;
			break;
			}
			
		}
	    if(deger) {
			entrySave(entry.getEntry(), entry.getPostId());
	    }
		return deger;
	}

}