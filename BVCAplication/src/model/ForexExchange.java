package model;

import java.util.Date;

public class ForexExchange implements Comparable<ForexExchange>{
	
	
	

	private String name;
	private Date Date;
	private String date;
	private Double price;
	
	
	public ForexExchange(String name, Date Date, double price) {
		super();
		
		this.name = name;
		this.Date = Date;
		this.price = price;
	}

	public ForexExchange(String name, String date, double price) {
		super();
		this.date=date;
		this.name = name;
		this.price = price;
	}
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDate() {
		return Date;
	}


	public void setDate(Date Date) {
		this.Date = Date;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public int compareTo(ForexExchange o) {
		// TODO Auto-generated method stub
		if(this.price < o.price) {
			return -1;
		}else{
			return 1;
		}
	}
	
	
	
	
	

}
