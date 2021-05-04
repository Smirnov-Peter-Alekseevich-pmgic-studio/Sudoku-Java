package sample.game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class NumberControll {
    public static boolean isEnd = false;
    public static int number = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void selEight(ActionEvent event) throws IOException {
        isEnd = true;
        number = 8;
        GameController.SetText(number);
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void selFive(ActionEvent event) throws IOException {
        isEnd = true;
        number = 5;
        GameController.SetText(number);

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void selFoor(ActionEvent event) throws IOException {
        isEnd = true;
        number = 4;
        GameController.SetText(number);

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void selNine(ActionEvent event) throws IOException {
        isEnd = true;
        number = 9;
        GameController.SetText(number);

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void selNull(ActionEvent event) throws IOException {
        isEnd = true;
        number = 0;
        GameController.SetText(number);

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void selOne(ActionEvent event) throws IOException {
        isEnd = true;
        number = 1;
        GameController.SetText(number);

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void selSeven(ActionEvent event) throws IOException {
        isEnd = true;
        number = 7;
        GameController.SetText(number);

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void selSix(ActionEvent event) throws IOException {
        isEnd = true;
        number = 6;
        GameController.SetText(number);

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void selThree(ActionEvent event) throws IOException {
        isEnd = true;
        number = 3;
        GameController.SetText(number);

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void selTwo(ActionEvent event) throws IOException {
        isEnd = true;
        number = 2;
        GameController.SetText(number);
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void initialize() {
        isEnd = false;
    }
}
