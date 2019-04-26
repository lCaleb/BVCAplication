package model;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import ARN.ArbolRojoNegro;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

public class BVC {

	public ObservableList<ArbolRojoNegro<Data>> divisa;
	
	
	public BVC()
	{
		
	}
	
	public Series<String, Double> readDataSet() throws IOException {
	
		File fili = new File ("./DataSet/BTCUSD prices.txt");
		FileReader fr = new FileReader (fili);
		BufferedReader br = new BufferedReader(fr);
		
		Series<String, Double> serie= new Series<>();
		
		String linea = br.readLine();
		while(linea!=null&&!linea.isEmpty()) {
		
		String[] datas= linea.split(", ");
		Data<String, Double> dato=new Data<String, Double>(datas[1],Double.parseDouble(datas[2]));
		serie.getData().add(dato);
	
		linea= br.readLine();
		}
		br.close();
		return serie;

	}
	
	
	public static void main(String[] args) throws IOException {
		BVC a= new BVC();
		a.readDataSet();
	}
	
	
	
	
}
