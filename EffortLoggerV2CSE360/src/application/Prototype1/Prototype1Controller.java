package application.Prototype1;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import application.Prototype1.PlanningPoker_Scene5Controller;
import java.io.IOException;
import javafx.event.ActionEvent;

public class Prototype1Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	private FXMLLoader loader;
	
	/*A low-complexity module that introduces new users unfamiliarized 
	  with Planning Poker to the scoring system through an interactive 
	  guided session example that provides instant feedback */
	
	//Function that loads the dashboard scene.
	public void backToDashboard(ActionEvent e) throws IOException {
		loader = new FXMLLoader(getClass().getResource("/application/DashboardScene.fxml"));
		root = loader.load();
		stage = (Stage) ((Node)e.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//Function that loads the Planning Poker Scene 1 - Initial User Story presentation and Discussion
	public void startPlanningPoker(ActionEvent e) throws IOException {
		loader = new FXMLLoader(getClass().getResource("PlanningPoker_Scene1.fxml"));
		root = loader.load();
		stage = (Stage) ((Node)e.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	} 
	
	//Function that loads the Planning Poker Scene 2 - Initial Voting Round
	public void startVoting(ActionEvent e) throws IOException {
		loader = new FXMLLoader(getClass().getResource("PlanningPoker_Scene2.fxml"));
		root = loader.load();
		stage = (Stage) ((Node)e.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//Function that loads the Planning Poker Scene 3 - Post-voting discussion
	public void startDiscussion(ActionEvent e) throws IOException {
		loader = new FXMLLoader(getClass().getResource("PlanningPoker_Scene3.fxml"));
		root = loader.load();
		stage = (Stage) ((Node)e.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//Function that loads the Planning Poker Scene 4 - Second voting round
	public void startVotingAgain(ActionEvent e) throws IOException {
		loader = new FXMLLoader(getClass().getResource("PlanningPoker_Scene4.fxml"));
		root = loader.load();
		stage = (Stage) ((Node)e.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//	//Function that loads the Planning Poker Scene 5 - Final discussion and wrap up. 
	//This also calls the updateLabels() function inside the Scene 5 Controller.
	public void finalDiscussion(ActionEvent e) throws IOException {
		loader = new FXMLLoader(getClass().getResource("PlanningPoker_Scene5.fxml"));
		root = loader.load();
		PlanningPoker_Scene5Controller ctrl = loader.getController();
		ctrl.updateLabels(e);
		stage = (Stage) ((Node)e.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
