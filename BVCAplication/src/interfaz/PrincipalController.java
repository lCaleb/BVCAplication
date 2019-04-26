package interfaz;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import model.BVC;

public class PrincipalController {
	
	private BVC bvc;
	private Main main;
	

    @FXML
    private LineChart<String, Double> lineChart;
	
	
	public void activeChart() {
		
		Series<String, Double> serie;
		try {
			serie = bvc.readDataSet();
			
			lineChart.getData().add(serie);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Series<String, Double> serie= new Series<String, Double>();
//		serie.getData().add(new Data<String, Double>("AUG",34.3));
//		serie.getData().add(new Data<String, Double>("SET",14.3));
//		serie.getData().add(new Data<String, Double>("OCT",20.3));
		
		
		
		
		
	}
	
	
	
	
	
	public void linker(Main main, BVC bvc) {
		this.bvc=bvc;
		this.main=main;
	}
	
}
