package com.parkinglot.model;

/**
 * @author Durai
 *
 */
public class Car {

	String regNum;
	String color;

	public Car(String regNum, String color) {
		this.regNum = regNum;
		this.color = color;
	}

	public String getRegNum() {
		return this.regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
