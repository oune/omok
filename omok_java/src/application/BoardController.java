package application;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BoardController {

    @FXML
    private ImageView board;

    @FXML
    void mouseClickHnadler(MouseEvent event) {
    	System.out.println("x : " + event.getX());
    	System.out.println("y : " + event.getY());
    	System.out.println("s` x : " + event.getSceneX());
    	System.out.println("s` y : " + event.getSceneY());
    }

}
