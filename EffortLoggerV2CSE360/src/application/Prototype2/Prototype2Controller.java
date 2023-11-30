package application.Prototype2;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Prototype2Controller {
    // Declare class variables
    public TextField usernameField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private FXMLLoader loader;
	
	public void backToDashboard(ActionEvent e) throws IOException {
		loader = new FXMLLoader(getClass().getResource("/application/DashboardScene.fxml"));
		root = loader.load();
		stage = (Stage) ((Node)e.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
    // Event handler to initialize the main scene
    public void startInitScene(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("Prototype2Scene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
	
    // Event handler to start role scene and check user roles
    public void startRoleScene(ActionEvent e) throws IOException {
        // Read user roles from file
        Map<String, String> userRoles = readUserRoles(System.getProperty("user.dir") + "/src/application/Prototype2/user_roles.txt");

        // Take input from interface
        String username = usernameField.getText();
        String role = "";

        boolean roleFound = false;
        boolean usernameExists = false;

        try {
            // Get role for the provided username
            role = userRoles.get(username);
        } catch (ArithmeticException d) {
            // Handle the exception 
            role = "Not found";
        }

        loader = new FXMLLoader(getClass().getResource("RoleScene.fxml"));

        try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/application/Prototype2/roles.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (role != null) {
                    usernameExists = true;
                    // Assuming roles are one per line in the text file
                    if (role.equals(line.trim())) {
                        roleFound = true;
                        break;
                    }
                }
            }
        }

        if (usernameExists) {
            // Display whether data will be tagged with role based on roleFound
            if (roleFound) {
                role = "(" + role + ") will be tagged with your logs and be visible to management";
                loader.getNamespace().put("Role", role);
            } else {
                role = "(" + role + ") will not be tagged with your logs to keep your data anonymous";
                loader.getNamespace().put("Role", role);
            }
        } else {
            role = "was not found in the database. Ensure your username is correct or contact an admin for help.";
            loader.getNamespace().put("Role", role);
        }

        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    // Read usernames and roles from a text file into a map
    private static Map<String, String> readUserRoles(String filePath) {
        Map<String, String> userRoles = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String role = parts[1].trim();
                    userRoles.put(username, role);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userRoles;
    }
}
