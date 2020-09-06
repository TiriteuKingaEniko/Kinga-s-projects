package org.fasttrackit.pojo;

import java.util.Date;

public class Week {
private int id;
private int userId;
private String name;
private Date startDate;
private Date endDate;



public Week(int id, int userId, String name, Date startDate, Date endDate) {
	super();
	this.id = id;
	this.userId = userId;
	this.name = name;
	this.startDate = startDate;
	this.endDate = endDate;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}

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
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

}
