package org.fasttrackit.pojo;

import java.util.ArrayList;

public class Receipt {
 private int id;
 private String name;
 private String description;
 private float preparingMinutes;
 private ArrayList < ReceiptIngredient> ingredientList;
 private ReceiptType type;
 
 
public Receipt(int id, String name, String description, float preparingMinutes,
		ArrayList<ReceiptIngredient> ingredientList, ReceiptType type) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.preparingMinutes = preparingMinutes;
	this.ingredientList = ingredientList;
	this.type = type;
}
public Receipt() {

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
public float getPreparingMinutes() {
	return preparingMinutes;
}
public void setPreparingMinutes(float preparingMinutes) {
	this.preparingMinutes = preparingMinutes;
}
public ArrayList<ReceiptIngredient> getIngredientList() {
	return ingredientList;
}
public void setIngredientList(ArrayList<ReceiptIngredient> ingredientList) {
	this.ingredientList = ingredientList;
}
public ReceiptType getType() {
	return type;
}
public void setType(ReceiptType type) {
	this.type = type;
}
 
}
