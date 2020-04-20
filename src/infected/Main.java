package infected;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;


public class Main extends Application {
    Stage window;
    TextField nameInput;
    Label countryLabel, symptomLabel;
    ComboBox symptomBox, countryBox;
    Button startButton;
    
	@Override
	public void start(Stage primaryStage) {
		try {
	        window = primaryStage;
	        window.setTitle("Virus Infection Game");
			TilePane root = new TilePane();
			
			// Title
			startButton = new Button("Start Game");
			// create action for start button
			startButton.setOnAction(e -> {
				CountryView view = new CountryView();
			    primaryStage.getScene().setRoot(view.getRootPane());
			});
			// name input
			nameInput = new TextField();
			nameInput.setPromptText("Name");
			
			symptomLabel = new Label("Symptoms");
			symptomBox = new ComboBox();
			
			countryLabel = new Label("Choose the country");
			countryBox = new ComboBox<>(FXCollections.observableArrayList(readNames("countries.txt")));
			
			VBox vBox = new VBox(nameInput, symptomLabel, symptomBox, countryLabel, countryBox, startButton);
			
			Scene scene = new Scene(vBox,400,400);
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
	
	private static ArrayList<String> readNames(String fname)
	{
		ArrayList<String> names = new ArrayList<String>();
        try (Scanner fileReader = new Scanner(new File(fname))){
            while (fileReader.hasNextLine()) // loop through the entire file
            {
                names.add(fileReader.nextLine());
            }
        }catch (FileNotFoundException e){
                e.printStackTrace();
        }
        return names;
	}
}