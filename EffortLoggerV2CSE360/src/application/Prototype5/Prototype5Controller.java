package application.Prototype5;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Prototype5Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // prototype 5 main page
    public void backToDashboard(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/DashboardScene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private TextField reportsField;
    @FXML
    private Label resultLabel;

    // Updated method for submitting reports
    @FXML
    public void submitReports() {
        String input = reportsField.getText();

        int numberOfReports = 0;
        
        try {
            numberOfReports = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            showAlert("Invalid Input", "Please enter a valid number and try again.");
            return;
        }
        
     
        // Compare the number of reports and show the appropriate message
        if (numberOfReports < 20) {
            resultLabel.setText("Not Enough Reports: The results are hidden.");
        } else{
            resultLabel.setText("The reports have been successfully submitted.");
        }
    }
    
    //IGNORE: PREVIOUS VERSION
    /*
    public void openReportEntryDialog() {
        // Create a new dialog for report entry
        Stage stage = new Stage();
        stage.setTitle("Report Entry");

        VBox vbox = new VBox(10);
        Label label = new Label("Please enter the number of reports:");
        reportsField = new TextField();
        Button submitButton = new Button("Submit");

        submitButton.setOnAction(e -> submitReports());

        vbox.getChildren().addAll(label, reportsField, submitButton);

        Scene scene = new Scene(vbox, 300, 150);
        stage.setScene(scene);
        stage.show();
    }
    */

    // shows alerts
    
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
