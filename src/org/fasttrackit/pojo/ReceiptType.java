package org.fasttrackit.pojo;

public class ReceiptType {
private int id;
private String name;
private String description;


public ReceiptType(int id, String name, String description) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
}
public ReceiptType() {
	// TODO Auto-generated constructor stub
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

	
}
