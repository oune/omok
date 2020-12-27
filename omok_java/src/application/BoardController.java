package application;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import main.Game;
import main.Player;

public class BoardController implements Initializable{
    @FXML
    private AnchorPane boardPane;
    @FXML
    private ImageView board;
  
    private Color stone = Color.BLACK;
    private Game now;
    
    private void toggleStone() {
    	stone = (stone == Color.BLACK)? Color.WHITE : Color.BLACK; 
    }
    @Override
    public void initialize(java.net.URL arg0, ResourceBundle arg1) {
    	now = new Game(new Player("dsfdsa", "123", "±è¾ç½ÄÇÏ´Â±è¾¾"), new Player("gdsag", "1234","ÀÌ»çÇÏ´ÂÀÌ¾¾"));
    }

    @FXML
    void mouseClickHnadler(MouseEvent event) {
    	int x, y;
    	
    	x = (int)getPosition(event.getX());
    	y = (int)getPosition(event.getY());
    	System.out.println("x : " +  x + ", y : " + y);
    	
    	Circle c = getStone(x, y, stone);
    	boardPane.getChildren().add(c);
    	
    	now.play(x, y);
    	
    	System.out.println(now.toString());
    	
    	if (now.isWin(x, y)) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    	    alert.setTitle("°ÔÀÓ °á°ú");
    	    alert.setHeaderText("½Â¸®ÇÏ¼Ì½À´Ï´Ù.");
    	    alert.setContentText("" + now.getNowPlayer());
            alert.showAndWait();
    	}
    	
    	toggleStone();
    }
    
    private long getPosition(double num) {
    	return Math.round((num - 11) /26);
    }
    
    private int getPosition(int num) {
    	return num * 26 + 16;
    }
    
    private Circle getStone(int x, int y, Color color) {
    	Circle c = new Circle(getPosition(x), getPosition(y), 8);
    	c.setFill(color);
    	c.setStroke(color);
    	c.setStrokeWidth(5);
    	
    	return c;
    }
}
