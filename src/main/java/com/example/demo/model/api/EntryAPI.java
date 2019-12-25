package com.example.demo.model.api;

import java.util.ArrayList;

import com.example.demo.model.Like;
import com.example.demo.model.User;

/**
 * @author OnurcanAtaol
 *
 */
public class EntryAPI 
{	
	private String title;
	private long postId;
	private  String entry;
	private long likeCount;
	private long dislikeCount;
	private Boolean lastLike;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	private String nickname;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String date;


	public ArrayList<Like> getLikecontrol() {
		return likecontrol;
	}
	public void setLikecontrol(ArrayList<Like> likecontrol) {
		this.likecontrol = likecontrol;
	}
	private ArrayList<Like> likecontrol;
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	public long getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(long likeCount) {
		this.likeCount = likeCount;
	}
	public long getDislikeCount() {
		return dislikeCount;
	}
	public void setDislikeCount(long dislikeCount) {
		this.dislikeCount = dislikeCount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getLastLike() {
		return lastLike;
	}
	public void setLastLike(Boolean lastLike) {
		this.lastLike = lastLike;
	}
	
	
	
	
	
	
	
	

}
