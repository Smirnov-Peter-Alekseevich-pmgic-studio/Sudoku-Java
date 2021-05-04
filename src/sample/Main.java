package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.game.ChempionController;
import sample.game.GameController;

import java.io.IOException;

public class Main extends Application {
    static Stage ps;
    @Override
    public void start(Stage primaryStage) throws Exception{
        ps = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Sudoku / Main Page");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
        ChempionController.SetStage(ps);
    }

    public static void Play(Controller.Difficulty difficulty) throws IOException {
        Group root = new Group();
        ObservableList list = root.getChildren();
        GameController.setDifficulty(difficulty,list);
        Scene scene = new Scene(root, 500, 500);
        ps.setTitle("Sudoku / Play");
        ps.setScene(scene);
        ps.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
