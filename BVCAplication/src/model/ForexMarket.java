package model;

import java.util.Date;

import ARN.ArbolRojoNegro;



public class ForexMarket implements DataAnalysis{
	
	
	private String name;
	
	ArbolRojoNegro<ForexExchange> forexMarket;

	public ForexMarket() {
		super();
		forexMarket = new ArbolRojoNegro<ForexExchange>();
	}

	public ArbolRojoNegro<ForexExchange> getForexMarket() {
		return forexMarket;
	}

	public void setForexMarket(ArbolRojoNegro<ForexExchange> forexMarket) {
		this.forexMarket = forexMarket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Double maxValue() {
		// TODO Auto-generated method stub
		return forexMarket.darMayor().getPrice();
	}

	@Override
	public Double minValue() {
		// TODO Auto-generated method stub
		return forexMarket.darMinimo().getPrice();
	}

	@Override
	public Date[] greatestGrowth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean higherPriceThan(Double price) {
		if(forexMarket.darMayor().getPrice() > price) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
