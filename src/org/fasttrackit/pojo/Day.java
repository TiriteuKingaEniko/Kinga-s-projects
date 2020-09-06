package org.fasttrackit.pojo;

import java.util.ArrayList;

public class Day {
private int id;
private Week week;
private DayOfTheWeek name;
private ArrayList<Receipt> breakfastReceipt, lunchReceipt, dinnerReceipt;


public Day(int id, Week week, DayOfTheWeek name, ArrayList<Receipt> breakfastReceipt, ArrayList<Receipt> lunchReceipt,
		ArrayList<Receipt> dinnerReceipt) {
	super();
	this.id = id;
	this.week = week;
	this.name = name;
	this.breakfastReceipt = breakfastReceipt;
	this.lunchReceipt = lunchReceipt;
	this.dinnerReceipt = dinnerReceipt;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Week getWeek() {
	return week;
}
public void setWeek(Week week) {
	this.week = week;
}
public DayOfTheWeek getName() {
	return name;
}
public void setName(DayOfTheWeek name) {
	this.name = name;
}
public ArrayList<Receipt> getBreakfastReceipt() {
	return breakfastReceipt;
}
public void setBreakfastReceipt(ArrayList<Receipt> breakfastReceipt) {
	this.breakfastReceipt = breakfastReceipt;
}
public ArrayList<Receipt> getLunchReceipt() {
	return lunchReceipt;
}
public void setLunchReceipt(ArrayList<Receipt> lunchReceipt) {
	this.lunchReceipt = lunchReceipt;
}
public ArrayList<Receipt> getDinnerReceipt() {
	return dinnerReceipt;
}
public void setDinnerReceipt(ArrayList<Receipt> dinnerReceipt) {
	this.dinnerReceipt = dinnerReceipt;
}

}
