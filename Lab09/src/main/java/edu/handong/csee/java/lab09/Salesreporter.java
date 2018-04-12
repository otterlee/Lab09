package edu.handong.csee.java.lab09;

import java.util.Scanner;
/**
 * This is a class that has instance variable about salesman's data and array of Salesman.
 * In this class, instantiate class Salesman, and includes methods that get data, compile statistics and print-out result.
 * 
 * @author Sua Lee
 *
 */
public class Salesreporter {
	private double highestSales;//Declare a private double instance variable 'highestSales'.
	private double averageSales;//Declare a private double instance variable 'averageSales'.
	private Salesman[] Team; //Declare Salesman array 'Team'.
	private int numOfSalesman; //Declare a private integer instance variable 'numOfSalesman'.
	
	/**
	 * This is a constructor method.
	 * It takes one input number to 'numOfSalesman'.
	 */
	Salesreporter() {//no parameter.
		System.out.println("Enter number of salesman");//prompt to enter the # of salesman.
		Scanner myScanner = new Scanner(System.in); //instantiate Scanner to myScanner.
		numOfSalesman = myScanner.nextInt();//take a number and put it into numOfSalesman.
	}
	/**
	 * This is main method. 
	 * In this method, call method that get the data, calculate the average of sales and find the highest sales.
	 * And print-out all results.
	 * @param args(Don't use this parameter in this class.)
	 */
	public static void main(String[] args) {
		Salesreporter myReporter = new Salesreporter(); //instantiate class Salesreporter as myReporeter
		myReporter.getData();//call method 'getData' to get data about each salesman.
		myReporter.calculateAverageSales();//call method 'calculateAverageSales' to calculate average of sales.
		myReporter.highestSales();//call method 'highestSales' to get the highest sales.
		myReporter.printOutResults();//call method 'printOutResults' to print-out results.
	}
	/**
	 * This is a method that gets input data and puts them into the Salesman's instance variables.
	 * In this method, declare the Salesman array 'Team' and instantiate class Salesman to mySalesman. 
	 * And by using setter method, set the data of salesman.
	 */
	public void getData() {
		Team = new Salesman[numOfSalesman]; //Declare a Salesman array 'Team'. and its size is numOfSalesman.
		for(int i=0;i<numOfSalesman;i++) {//Loop '# of Salesman' time.
			Scanner myScanner = new Scanner(System.in);//Instantiate  Scanner to myScanner.
			System.out.println("Enter data for associate number "+(i+1)+".");//print-out message to enter the salesman's data.
			System.out.print("Enter name :");//prompt to enter the name.
			String name = myScanner.nextLine();//get a name and put it into local variable name.
			System.out.print("Enter Sales: $");//prompt to enter the Sales.
			double sales = myScanner.nextDouble();//get a sales and put it into local variable sales.

			Salesman mySalesman = new Salesman();//Instantiate Salesman to mySalesman
			mySalesman.setName(name);//set the salesman' name(instance variable) by Using setName method.
			mySalesman.setSales(sales);//set the salesman's sales(instance variable) by Using setName method.
			Team[i] = mySalesman;//put instance mySalesman to instance Team[i](reference).
		}
	}
	
	/**
	 * This is a method that calculate the average of sales.
	 * Declare the variable 'sum' and initiate it to 0.
	 * And add the each sales of salesman in loop, divide sum to # of salesman.
	 */
	public void calculateAverageSales() {
		double sum = 0; //Declare local variable sum and initiate it 0.
		for(int i=0;i<Team.length;i++) { //Loop 'Team.length' time.
			double sales = Team[i].getSales();//put Salesman(Team[i])'s sales to local variable 'sales'
			sum = sum + sales;//add sales to sum;
		}
		averageSales = sum/ Team.length; //get average by dividing sum to Team.length.
	}
	/**
	 * This is a method that finds the highest sales.
	 * In loop, compare each salesman's sales back and forth.
	 */
	public void highestSales() {
		highestSales = Team[0].getSales(); //set the initial value of highestSales as first salesman's sales.
		for(int i=0;i<Team.length-1;i++) {//Loop 'Team.length-1' times.
			if(Team[i].getSales()<Team[i+1].getSales()) {//Compare the value of sales back and forth.
				highestSales = Team[i+1].getSales();//put the larger one into highestSales.
			}
		}
	}
	/**
	 * This is a method that prints-out the results.
	 * First, print-out average sales and highest sales and print-out the data of salesman who has the highest sales.
	 * and print-out the rest salesman's data and difference between each sales and average.
	 */
	public void printOutResults() {
		System.out.printf("Average sales per associate is %.1f\n",averageSales);//print-out average sales. to print the average value to one decimal point, use printf.
		System.out.println("The highest sales figure is $"+highestSales);//print-out highest sales.
		int highestSalesIndex=0;//Declare local variable to put highest sales index.
		System.out.println("The following had the highes sales:");//print-out message that tells following lines are about the highest sales.
		for(int i=0;i<Team.length;i++) {//Loop 'the # of salesman' times.
			if(Team[i].getSales()== highestSales) {//find the salesman who has the highest sales record.
				System.out.println("Name: "+Team[i].getName());//print-out his or her name
				System.out.println("Sales: $"+Team[i].getSales());//print-out his or her sales.
				System.out.printf("$%.1f above the average.\n",(Team[i].getSales()-averageSales));
				//print-out the difference between Team[i]'s sales and average sales. To print the average value to one decimal point, use printf.
				highestSalesIndex = i; //store the index of salesman who has highest record.
			}
		}
		System.out.println("The rest performed as follows:");//print-out message that tells following lines are about the rest salesman.
		for(int i=0;i<Team.length;i++) {//Loop '# of salesman' time.
			//print-out the result of rest salesman.
			if(i==highestSalesIndex) continue; //pass the case of salesman who has highest record.
			System.out.println("Name: "+Team[i].getName()); //print-out the name.
			System.out.println("Sales: $"+Team[i].getSales());//print-out the sales.
			if(Team[i].getSales() > averageSales) //if the sales is larger than average.
				System.out.printf("$%.1f above the average.\n",(Team[i].getSales()-averageSales));
			//print-out the difference between Team[i]'s sales and average sales. To print the average value to one decimal point, use printf.
			else if	(Team[i].getSales() < averageSales) //if the sales is smaller than average
				System.out.printf("$%.1f below the average.\n",(averageSales-Team[i].getSales()));
			//print-out the difference between Team[i]'s sales and average sales. To print the average value to one decimal point, use printf.	
		}
	}
}
