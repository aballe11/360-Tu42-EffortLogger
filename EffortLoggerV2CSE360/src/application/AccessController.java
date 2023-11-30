package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccessController {
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	
	public Label errorLabel;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void LogIn(ActionEvent event) throws IOException{
		//Get the text from the input fields
		String username = usernameField.getText();
		String password = passwordField.getText();
		//Check for correct input validation on both inputs and check for correct credentials in locally stored .txt file
		if(InputValidation.isUsernameValid(username) && 
				InputValidation.isPasswordValid(password) &&
				areCredentialsValid(username, password)) {
			
			//Load new scene, access controller and display it
			FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardScene.fxml"));
			root = loader.load();
			//DashboardController dashboardController = loader.getController();
			
			stage = (Stage) ((Node)event.getSource() ).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		} else {
			errorLabel.setText("Error! The username or password you entered is invalid. Try again!");
		}
	}
	
	public static boolean areCredentialsValid(String inputUsername, String inputPassword) {
        // File containing credentials
        String filename = "src/application/LocalCredentials.txt"; // Ensure this path is correct

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split by tab character
                String[] credentials = line.split("\t", -1);

                // Check if array contains both username and password
                if (credentials.length == 2) {
                    String username = credentials[0];
                    String password = credentials[1];

                    // Validate the input against the file's content
                    if (inputUsername.equals(username) && inputPassword.equals(password)) {
                        return true; // Valid credentials
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions appropriately for your application's requirements
        }

        return false; // Invalid credentials or other issues
    }
}
