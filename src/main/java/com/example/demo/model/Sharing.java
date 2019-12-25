package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Sharing 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Column
	private String title;
	
	@Column
	private String date;
	
	
	
	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Category category;
	
	@OneToMany(mappedBy = "sharing")
	@JsonIgnore
	private List<Entry> entryList;

	public List<Entry> getEntryList() {
		return entryList;
	}


	public void setEntryList(List<Entry> entryList) {
		this.entryList = entryList;
	}
	
	


	
	
	
	
	
	

}
