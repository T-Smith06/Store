/*Class:	CSE 1323L/W01
Date:		9/26/2019  
Name:		Terrence Smith
Assgnmt Name:	Store   
Assignment#:	Module 3A - Store
Resources: 	Introduction to Java Programming and Data Structures: Comp Version 11th e, 
 		Ch. 11. Also google on how to get average yearly tax*/

import java.text.DecimalFormat;

public class Store {
	private String storeName;
	private double salesTaxRate;
	// constructor with parameters
	Store(String storeName,double salesTaxRate){
		this.storeName = storeName;
		this.salesTaxRate = salesTaxRate;
	}
	//getters and setters
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public double getSalesTaxRate() {
		return salesTaxRate;
	}
	
	public void setSalesTaxRate(double salesTaxRate) {
		this.salesTaxRate = salesTaxRate;
	}
	
	public String toString() {
		return "Store Name: "+storeName+"\n"+"Sales Tax Rate: "+salesTaxRate;
	}
	//determines if store names and sales tax rates are equal
	public boolean equals(Store obj) {
		if(this.storeName == obj.storeName && this.salesTaxRate == obj.salesTaxRate)
			return true;
		else 
			return false;
	}

}

class YarnStore extends Store{
	private int yarnSold;
	private double avgPrice;
	//constructor with parameters
	public YarnStore(String storeName,double salesTaxRate,int yarnSold,double avgPrice) {
		super(storeName,salesTaxRate);
		this.yarnSold = yarnSold;
		this.avgPrice = avgPrice;
	}
	//getters and setters
	public int getYarnSold() {
		return yarnSold;
	}
	
	public void setYarnSold(int yarnSold) {
		this.yarnSold = yarnSold;
	}
	
	public double getAvgPrice() {
		return avgPrice;
	}
	
	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}
	
	public String toString() {
		return super.toString()+"\nSkeins of yarn sold in a year: "+yarnSold+"\nAverage price per skein: $"+avgPrice;
	}
	
	public boolean equals(YarnStore obj) {
		if(this.yarnSold == obj.yarnSold && this.avgPrice == obj.avgPrice)
			return true;
		else 
			return false;
	}
	
	public double avgYearlyTax() {
		double tax = avgPrice * yarnSold * getSalesTaxRate();
		return tax;
	}
}

class TestStore {
	public static void main(String[] args) {
		DecimalFormat decFor = new DecimalFormat("0.00");

		Store store1 = new Store("Threads",0.0725);
		System.out.println(store1.toString());
		
		System.out.println();
		
		YarnStore yarn1 = new YarnStore("Yarn Barn",0.0725,585,2.55);
		YarnStore yarn2 = new YarnStore("Yarn Hut",0.0725,1000,2.55);
		System.out.println(yarn1.toString());
		System.out.println("Average taxes per year: $"+decFor.format(yarn1.avgYearlyTax()));
		System.out.println("Yarn stores are equal: "+yarn1.equals(yarn2));
	}
}
