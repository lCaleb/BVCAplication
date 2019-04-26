package model;

import java.util.Date;

import AVL.ArbolAVL;


public class CapitalMarket implements DataAnalysis{
	
	
	//AVL
	private String name;
	
	

	private ArbolAVL<ForexExchange> capitalMarket;

	public CapitalMarket() {
		super();
		capitalMarket = new ArbolAVL<ForexExchange>();
	}

	public ArbolAVL<ForexExchange> getCapitalMarket() {
		return capitalMarket;
	}

	public void setCapitalMarket(ArbolAVL<ForexExchange> capitalMarket) {
		this.capitalMarket = capitalMarket;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Double maxValue() {
		return capitalMarket.darMayor().getPrice();
	}

	@Override
	public Double minValue() {
		return capitalMarket.darMenor().getPrice();
	}

	@Override
	public Date[] greatestGrowth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean higherPriceThan(Double price) {
		if(capitalMarket.darMayor().getPrice() > price) {
			return true;
		}else {
			return false;
		}
	}
	

}
