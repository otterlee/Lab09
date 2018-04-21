package edu.handong.csee.java.lab09;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
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
	private ArrayList<Salesman> Team; //Declare Salesman arrayList 'Team'.
	private int numOfSalesman; //Declare a private integer instance variable 'numOfSalesman'.

	/**
	 * This is a constructor method.
	 * It takes one input number to 'numOfSalesman'.
	 */

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
		Scanner myScanner = new Scanner(System.in);//Instantiate  Scanner to myScanner.
		Team = new ArrayList<Salesman>();//create instance ArrayList Team.
		System.out.println("Enter the Salesman data."); //prompt to enter data.

		while(true) {//Loop until answer is not yes
			System.out.print("Enter name :");//prompt to enter the name.
			String name = myScanner.nextLine();//get a name and put it into local variable name.
			System.out.print("Enter Sales: $");//prompt to enter the Sales.
			double sales = myScanner.nextDouble();//get a sales and put it into local variable sales.
			myScanner.nextLine();//delete remained buffer.
			Salesman salesman = new Salesman(name, sales);//create Salesman instance 
			Team.add(salesman);//add object salesman as element into arrayList Team
			System.out.println("If you want to enter more data for salesman associate, type 'yes'");//print-out message to enter the salesman's data.
			//print-out message to know is there more data.
			String answer = myScanner.nextLine();//get the answer.
			if(!answer.equalsIgnoreCase("yes")) break;//If answer is not yes, break the loop.

		}
	}

	/**
	 * This is a method that calculate the average of sales.
	 * Declare the variable 'sum' and initiate it to 0.
	 * And add the each sales of salesman in loop, divide sum to # of salesman.
	 */
	public void calculateAverageSales() {
		double sum = 0; //Declare local variable sum and initiate it 0.
		for(Salesman nextman: Team) { //loop by using for-each statement. set nextman one by one from array Team
			double sales = nextman.getSales();//put Salesman(Team[i])'s sales to local variable 'sales'
			sum = sum + sales;//add sales to sum;
		}
		averageSales = sum/Team.size(); //get average by dividing sum to Team's size.
	}
	/**
	 * This is a method that finds the highest sales.
	 * In loop, compare each salesman's sales back and forth.
	 */
	public void highestSales() {
		highestSales = 0; //set the initial value of highestSales as 0.
		for(Salesman nextman: Team) {//Loop by using for-each statement.
			if(nextman.getSales()>highestSales) {//Compare the value of sales back and forth.
				highestSales = nextman.getSales();//put the larger one into highestSales.
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
		for(Salesman nextman: Team) {//Loop using for-each statement.
			if(nextman.getSales()== highestSales) {//find the salesman who has the highest sales record.
				System.out.println("Name: "+nextman.getName());//print-out his or her name
				System.out.println("Sales: $"+nextman.getSales());//print-out his or her sales.
				System.out.printf("$%.1f above the average.\n",(nextman.getSales()-averageSales));
				//print-out the difference between Team[i]'s sales and average sales. To print the average value to one decimal point, use printf.
				highestSalesIndex = Team.indexOf(nextman); //store the index of salesman who has highest record.
			}
		}
		System.out.println("The rest performed as follows:");//print-out message that tells following lines are about the rest salesman.
		for(Salesman nextman: Team) {//Loop '# of salesman' time.
			//print-out the result of rest salesman.
			if(Team.indexOf(nextman)==highestSalesIndex) continue; //pass the case of salesman who has highest record.
			System.out.println("Name: "+ nextman.getName()); //print-out the name.
			System.out.println("Sales: $"+ nextman.getSales());//print-out the sales.
			if(nextman.getSales() > averageSales) //if the sales is larger than average.
				System.out.printf("$%.1f above the average.\n",(nextman.getSales()-averageSales));
			//print-out the difference between nextman's sales and average sales. To print the average value to one decimal point, use printf.
			else if	(nextman.getSales() < averageSales) //if the sales is smaller than average
				System.out.printf("$%.1f below the average.\n",(averageSales-nextman.getSales()));
			//print-out the difference between nextman's sales and average sales. To print the average value to one decimal point, use printf.	
		}
	}
}
