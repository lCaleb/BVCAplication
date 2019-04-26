package interfaz;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.BVC;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	BVC bvc= new BVC();
	@Override
	public void start(Stage primaryStage) {
		
		try {
			FXMLLoader loader= new FXMLLoader(getClass().getResource("Principal.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			PrincipalController principal= loader.getController();
			principal.linker(this, bvc);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
