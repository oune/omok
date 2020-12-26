package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Button playButton;

    @FXML
    void playClickHandler(ActionEvent event) {
    	System.out.println(".");
        Stage primaryStage = (Stage)playButton.getScene().getWindow();
        Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/layout/board.fxml"));
			Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
