package Phase3Implementation;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NurseDashboard {
	// Represents the dashboard interface for nurses in the healthcare management system
	 public static void display(Stage window, User user) {
	        VBox layout = new VBox(10);
	        Color backColor = Color.web("#CFD9F7");
	        layout.setStyle("-fx-background-color: #" + backColor.toString().substring(2, 8) + ";");
	        
	        Label title = new Label("UPCOMING APPOINTMENT");
	        title.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 18px;-fx-underline: true;");
	        title.setTranslateX(10);
	        // Used to display upcoming appointments retrieved from the Appointment class
	        ListView<String> patientAptList = new ListView<>();
	        
	        ArrayList<Appointment> appointments = Appointment.getAppointments();
	        for (Appointment appointment : appointments) {
	        	patientAptList.getItems().add(appointment.toString());
	        }

	        Button addPatientButton = new Button("Add New Patient");
	        addPatientButton.setTranslateX(20);
	        addPatientButton.setOnAction(e -> {
	            // Logic to add new patient
	        	Stage addPatientStage = new Stage();
	        	AddPatientInformation addPatientInformation = new AddPatientInformation();
	        	addPatientInformation.start(addPatientStage, user);
	        });

	        Button patientSearchButton = new Button("Patient Search");
	        patientSearchButton.setTranslateX(20);
	        patientSearchButton.setOnAction(event -> {
	        	
	        	PatientSearch.start(window, user, null);

	        });
	        Button logoutButton = new Button("Logout");
	        logoutButton.setTranslateX(220);
	        logoutButton.setTranslateY(-10);
	        logoutButton.setOnAction(e -> {
	            HealthcareManagementSystemGUI loginpage = new HealthcareManagementSystemGUI();
	            loginpage.start(window);
	        });

	        
	        layout.getChildren().addAll(title, patientAptList, addPatientButton, patientSearchButton, logoutButton);
	        Scene scene = new Scene(layout, 300, 400);
	        window.setScene(scene);
	        window.setWidth(300);
	        window.setHeight(400);
	        window.setTitle("Doctor Dashboard");
	        window.show();
	    }
	    
}
