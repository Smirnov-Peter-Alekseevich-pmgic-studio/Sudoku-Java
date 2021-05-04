package sample.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class ChempionController {

    private static Stage stage;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void Close(ActionEvent event) {
        System.out.println("CLose");
        stage.close();
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }
    public static void SetStage(Stage st){
        stage=st;
    }
    @FXML
    void initialize() {

    }
}
