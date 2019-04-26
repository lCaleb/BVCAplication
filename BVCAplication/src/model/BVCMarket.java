package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BVCMarket {
	
	
	
	
	private ObservableList<ForexMarket> forexMarkets;
	private ObservableList<CapitalMarket> capitalMarkets;
	
	private File currentFile; 
	private Date initialDate; private Date finalDate;
	
	private CapitalMarket actualCMarket;
	private ForexMarket actualFMarket;
	
	public BVCMarket() {
		super();
		forexMarkets = FXCollections.observableArrayList();
		capitalMarkets = FXCollections.observableArrayList();
		actualCMarket = null;
		actualFMarket = null;
	}

	public void loadForexMarket() {
		try {
		FileReader fr = new FileReader(currentFile);
		BufferedReader br = new BufferedReader(fr);
		String cadena = "";
		
		ForexMarket forexMarket = new ForexMarket();
		String name1 = "";
		
		while((cadena= br.readLine())!= null) {
			String[] elements = cadena.split(",");
			String name = elements[0];
			name1 = name;
			String cdate = elements[1];
			String cdate1 = cdate.substring(1,cdate.length());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm");
			
			Date date = null;
			try {
				date = sdf.parse(cdate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(date.toString());
			System.out.println(date);
			System.out.println(date.compareTo(finalDate) + "Initial: " + date.compareTo(initialDate));
			if(date.compareTo(finalDate) <= 0 && date.compareTo(initialDate) >= 0) {
				double price = Double.parseDouble(elements[2]);
				ForexExchange forexExchange = new ForexExchange(name,date,price);
				forexMarket.getForexMarket().insertar(forexExchange);
			}
		}
		forexMarket.setName(name1);
		forexMarkets.add(forexMarket);
		
		br.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void loadCapitalMarket() {
		try {
			FileReader fr = new FileReader(currentFile);
			BufferedReader br = new BufferedReader(fr);
			String cadena = "";
			
			CapitalMarket capitalMarket = new CapitalMarket();
			String name1 = "";
			
			while((cadena= br.readLine())!= null) {
				String[] elements = cadena.split(",");
				String name = elements[0];
				name1 = name;
				String cdate = elements[1];
				String cdate1 = cdate.substring(1,cdate.length());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm");
				
				Date date = null;
				try {
					date = sdf.parse(cdate1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(date.toString());
				double price = Double.parseDouble(elements[2]);
				if(date.compareTo(finalDate) <= 0 && date.compareTo(initialDate) >= 0) {
					System.out.println(date.toString());
					ForexExchange forexExchange = new ForexExchange(name,date,price);
					//capitalMarket.getCapitalMarket().add(forexExchange.getPrice(), forexExchange);
					capitalMarket.getCapitalMarket().insertar(forexExchange);
					
				}	
			}
			
			capitalMarket.setName(name1);
			capitalMarkets.add(capitalMarket);
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ObservableList<String> listOfMarkets(){
		
		ObservableList<String> list = FXCollections.observableArrayList();
		for(int i=0; i < forexMarkets.size(); i++) {
			list.add(forexMarkets.get(i).getName());
		}
		for(int i=0; i < capitalMarkets.size(); i++) {
			list.add(capitalMarkets.get(i).getName());
		}
		
		return list;
	}
	
	public void searchForMarket(String name) {
		if(name.startsWith("#")) {
			for (int i = 0; i < capitalMarkets.size(); i++) {
				if(name.equals(capitalMarkets.get(i).getName())) {
					actualCMarket = capitalMarkets.get(i);
					actualFMarket = null;
				}
			}
		}else {
			for (int i = 0; i < forexMarkets.size(); i++) {
				if(name.equals(forexMarkets.get(i).getName())) {
					actualFMarket = forexMarkets.get(i);
					actualCMarket = null;
				}
			}			
		}
	}
	
	public ObservableList<String> listOfHigherPricesThan(Double price){
		ObservableList<String> list =  FXCollections.observableArrayList();
		
		for (int i = 0; i < capitalMarkets.size(); i++) {
			if(capitalMarkets.get(i).higherPriceThan(price)) {
				list.add(capitalMarkets.get(i).getName());
			}
		}
		
		for (int i = 0; i < forexMarkets.size(); i++) {
			if(forexMarkets.get(i).higherPriceThan(price)) {
				list.add(forexMarkets.get(i).getName());
			}
		}
		
		
		return list;
		
	}
	
	
	public ObservableList<ForexMarket> getForexMarkets() {
		return forexMarkets;
	}


	public void setForexMarkets(ObservableList<ForexMarket> forexMarkets) {
		this.forexMarkets = forexMarkets;
	}


	public ObservableList<CapitalMarket> getCapitalMarkets() {
		return capitalMarkets;
	}


	public void setCapitalMarkets(ObservableList<CapitalMarket> capitalMarkets) {
		this.capitalMarkets = capitalMarkets;
	}

	public File getCurrentFile() {
		return currentFile;
	}

	public void setCurrentFile(File currentFile) {
		this.currentFile = currentFile;
	}

	public CapitalMarket getActualCMarket() {
		return actualCMarket;
	}

	public void setActualCMarket(CapitalMarket actualCMarket) {
		this.actualCMarket = actualCMarket;
	}

	public ForexMarket getActualFMarket() {
		return actualFMarket;
	}

	public void setActualFMarket(ForexMarket actualFMarket) {
		this.actualFMarket = actualFMarket;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	
	
	
	
	
	

}
