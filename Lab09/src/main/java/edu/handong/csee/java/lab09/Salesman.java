package edu.handong.csee.java.lab09;

/**
 * This is a class that includes instance variables String 'name' and integer 'sales' and getter and setter methods.
 * @author Sua Lee
 *
 */
public class Salesman {
	private String name;
	private double sales;
	/**
	 * this is a method that returns saleman's name.
	 * @return name(String)
	 */
	Salesman(String name, double sales){
		this.name = name;
		this.sales = sales;
	}
	public String getName() {
		return name;
	}
	/**
	 * this is a method that sets saleman's name by received parameter.
	 * @param name(String)
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 	this is a method that returns saleman's sales.
	 * @return sales(integer)
	 */
	public double getSales() {
		return sales;
	}
	/**
	 * this is a method that sets saleman's sales by received parameter.
	 * @param sales(integer)
	 */
	public void setSales(double sales) {
		this.sales = sales;
	}
}
