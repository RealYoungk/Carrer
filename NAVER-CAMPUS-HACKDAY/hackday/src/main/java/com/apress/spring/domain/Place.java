package com.apress.spring.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Place {
	
	@Id
	private int id;
	private String name;
	private Date created;
	private int x;
	private int y;
	
	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	public Place(int id, String name, int x, int y, String date) throws
	
	ParseException{
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y;
		this.created = format.parse(date);
	}
	
	Place(){}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getCreatedAsShort() {
		return format.format(created);
	}
	
	public String toString() {
		StringBuilder value = new StringBuilder("* PlaceEntry(");
		value.append("name: ");
		value.append(name);
		value.append(",위도: ");
		value.append(x);
		value.append(",경도: ");
		value.append(y);
		value.append(",date: ");
		value.append(getCreatedAsShort());
		value.append(")");
		
		return value.toString();
	}
}
