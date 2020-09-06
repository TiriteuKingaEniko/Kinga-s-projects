package org.fasttrackit.pojo;

public class ReceiptIngredient {
private int id;
private int receiptId;
private Receipt receipt;
private int ingredientId;
private Ingredient ingredient;
private float quantity;


public ReceiptIngredient(int id, int receiptId, int ingredientId, float quantity) {
	super();
	this.id = id;
	this.receiptId = receiptId;
	this.ingredientId = ingredientId;
	this.quantity = quantity;

}
public ReceiptIngredient() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getReceiptId() {
	return receiptId;
}
public void setReceiptId(int receiptId) {
	this.receiptId = receiptId;
}
public Receipt getReceipt() {
	return receipt;
}
public void setReceipt(Receipt receipt) {
	this.receipt = receipt;
}
public int getIngredientId() {
	return ingredientId;
}
public void setIngredientId(int ingredientId) {
	this.ingredientId = ingredientId;
}
public Ingredient getIngredient() {
	return ingredient;
}
public void setIngredient(Ingredient ingredient) {
	this.ingredient = ingredient;
}
public float getQuantity() {
	return quantity;
}
public void setQuantity(float quantity) {
	this.quantity = quantity;
}



}
