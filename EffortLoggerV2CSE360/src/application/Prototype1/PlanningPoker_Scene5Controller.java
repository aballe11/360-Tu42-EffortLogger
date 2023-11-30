package application.Prototype1;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.ActionEvent;
public class PlanningPoker_Scene5Controller {
		private Stage stage;
		private Scene scene;
		private Parent root;
		private int finalScore;
		private FXMLLoader loader;
		
		//Labels
		@FXML
		private Label labelSofia;
		@FXML
		private Label labelBenjamin;
		@FXML
		private Label labelAmina;
		@FXML
		private Label labelHiroshi;
		
		//Code to update all labels based on the user's selected score card from the second voting round
		public void updateLabels(ActionEvent e) {
			finalScore = Integer.parseInt(((Button)e.getSource()).getText());
			labelSofia.setText(Integer.toString(finalScore));
			labelBenjamin.setText(Integer.toString(finalScore));
			labelAmina.setText(Integer.toString(finalScore));
			labelHiroshi.setText(Integer.toString(finalScore));
		}
		
		//Function ran to load the original dashboard on exit
		public void backToDashboard(ActionEvent e) throws IOException {
			loader = new FXMLLoader(getClass().getResource("/application/DashboardScene.fxml"));
			root = loader.load();
			stage = (Stage) ((Node)e.getSource() ).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
}
