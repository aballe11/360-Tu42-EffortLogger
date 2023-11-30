package application.Prototype3;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class Prototype3Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextArea reportTextArea1;
		public void backToDashboard(ActionEvent e) throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/DashboardScene.fxml"));
			root = loader.load();
			stage = (Stage) ((Node)e.getSource() ).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		public void submit1(ActionEvent e) {
		   	 String report1 = reportTextArea1.getText();
	    	 if(!report1.isEmpty()) {
	    		 System.out.println("Anonymous Report: " + report1);
	    	 } else {
	    		 System.out.println("Report can not be empty.");
	    	 }
	    	 reportTextArea1.clear();
	    }
}




