package com.apress.spring.domain;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;

//@Entity
public class User {

	@Id
	private String userId;
	private ArrayList<Place> history;
	
//	public User(String userId) throws
//	ParseException{
//		this.userId = userId;
//	}
	
	public User(String userId, Place place) throws
	ParseException{
		this.userId = userId;
		history.add(place);
	}
	
	
	User(){}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public ArrayList<Place> getHistory(){
		return history;
	}
	
	public void setHistory(Place place) {
		this.history.add(place);
	}
	
	public String toString() {
		StringBuilder value = new StringBuilder("*PlaceEntry(");
		
		value.append("userId: ");
		value.append(userId);
		
		for(Place place : history) {
			value.append(",place: ");
			value.append(place);
		}
		
		return value.toString();
	}
}
