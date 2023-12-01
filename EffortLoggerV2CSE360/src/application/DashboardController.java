package application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.event.ActionEvent;
//import application.Prototype1.Prototype1Controller;
//import application.Prototype2.Prototype2Controller;
//import application.Prototype3.Prototype3Controller;
//import application.Prototype4.Prototype4Controller;
//import application.Prototype5.Prototype5Controller;

public class DashboardController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//Function ran when selecting Prototype 1 button
	public void openPrototype1(ActionEvent e) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Prototype1/Prototype1Scene.fxml"));
		root = loader.load();
		//Get prototype controller to pass any information
		
		//Prototype1Controller prototype1Controller = loader.getController();
			//Use prototype1Controller to call any functions you want to pass parameters to.
		
		//Display the scene
		displayScene(e);
	}
	
	//Function ran when selecting Prototype 2 button
	public void openPrototype2(ActionEvent e) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Prototype2/Prototype2Scene.fxml"));
		root = loader.load();
		
		//Get prototype controller to pass any information
		//Prototype2Controller prototype2Controller = loader.getController();
			//Use prototype1Controller to call any functions you want to pass parameters to.
		
		//Display the scene
		displayScene(e);
	}
	
	//Function ran when selecting Prototype 3 button
	public void openPrototype3(ActionEvent e) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Prototype3/Prototype3Scene.fxml"));
		root = loader.load();
		
		//Get prototype controller to pass any information
		//Prototype3Controller prototype3Controller = loader.getController();
			//Use prototype1Controller to call any functions you want to pass parameters to.
		
		//Display the scene
		displayScene(e);
	}
	
	//Function ran when selecting Prototype 5 button
	public void openPrototype5(ActionEvent e) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Prototype5/Prototype5Scene.fxml"));
		root = loader.load();
		
		//Get prototype controller to pass any information
		//Prototype5Controller prototype5Controller = loader.getController();
			//Use prototype1Controller to call any functions you want to pass parameters to.
		
		//Display the scene
		displayScene(e);
	}

	//Function that displays the initial dashboard scene.
	private void displayScene(ActionEvent e) {
		//Display the scene
		stage = (Stage) ((Node)e.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
