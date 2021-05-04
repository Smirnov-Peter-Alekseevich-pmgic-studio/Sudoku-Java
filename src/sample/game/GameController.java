package sample.game;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Controller;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class GameController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane MainWindow;

    @FXML
    private Label logoApp;

    private static Controller.Difficulty difficulty;
    private static int numberIsOpenBoxes = 0;
    private static int[][] place = new int[9][9];
    private static int[][] nowPlace = new int[9][9];
    private static Vector2 vectorNow;
    private static ArrayList<Button> buttons;
    private static Button but;

    public static void setDifficulty(Controller.Difficulty difficulty, ObservableList game) {
        GameController.difficulty = difficulty;
        place = SudokuRenderer.GetSudoku();
        switch (difficulty){
            case EASE:
                numberIsOpenBoxes = 36;
                break;
            case MIDDLE:
                numberIsOpenBoxes = 30;
                break;
            case HARD:
                numberIsOpenBoxes = 28;
                break;
            case UNREAL:
                numberIsOpenBoxes = 22;
                break;
        }

        ArrayList<Vector2> openBoxes = new ArrayList<>();
        ArrayList<Vector2> closeBoxes = new ArrayList<>();
        buttons = new ArrayList<>();

        for(int i = 0;i < numberIsOpenBoxes;i++){
            Vector2 vec = new Vector2((int)  ((Math.random() * 9)),(int) ((Math.random() * 9)));
            if(ThereIsInList(openBoxes,vec))i--;
            else openBoxes.add(vec);
        }
        for(int x = 0;x < 9;x++){
            for(int y = 0;y < 9;y++){
                Vector2 vector = new Vector2(x,y);
                if(!ThereIsInList(openBoxes,vector)){
                    closeBoxes.add(vector);
                }
            }
        }
        for(int i = 0;i < 2;i++){
            Line line = new Line();
            line.setStartX(5 + 150 + 50 * (3 * i) + 12.5 + 15 * i);
            line.setStartY(0);
            line.setEndX(5 + 150 + 50 * (3 * i) + 12.5 + 15 * i);
            line.setEndY(500);
            line.setStrokeWidth(2.5);
            game.add(line);
            Line line2 = new Line();
            line2.setStartX(0);
            line2.setStartY(5 + 150 + 50 * (3 * i) + 12.5 + 15 * i);
            line2.setEndX(500);
            line2.setEndY(5 + 150 + 50 * (3 * i) + 12.5 + 15 * i);
            line2.setStrokeWidth(2.5);
            game.add(line2);
        }
        for(Vector2 vec : openBoxes){
            Label label = new Label();
            label.setFont(new Font("Mella Nissa",18));
            label.setText("" + place[vec.x][vec.y]);
            nowPlace[vec.x][vec.y] = place[vec.x][vec.y];
            label.setPrefWidth(50);
            label.setPrefHeight(50);
            label.setLayoutX(5 + 50 * vec.x + 5 * vec.x);
            label.setLayoutY(5 + 50 * vec.y + 5 * vec.y);
            label.setStyle("-fx-background-color: #AFEEEE");
            label.setAlignment(Pos.CENTER);
            game.add(label);
        }
        for(Vector2 vec : closeBoxes){
            Button button = new Button();
            button.setText(" ");
            button.setFont(new Font("Mella Nissa",14));
            button.setStyle("-fx-background-color: #AAF0D1");
            button.setPrefWidth(50);
            button.setPrefHeight(50);
            button.setLayoutX(5 + 50 * vec.x + 5 * vec.x);
            button.setLayoutY(5 + 50 * vec.y + 5 * vec.y);
            button.setId(vec.x + " " + vec.y);
            button.setOnAction(event -> {
                try {
                    GameController.SetValue(button);
                } catch (IOException e) {
                    System.out.println("error set action");
                    e.printStackTrace();
                }
            });
            game.add(button);
            buttons.add(button);
        }
    }
    private static boolean ThereIsInList(ArrayList<Vector2> list,Vector2 number){
        for (Vector2 i : list) {
            if(number.x == i.x && number.y == i.y)return true;
        }
        return false;
    }
    @FXML
    void initialize() throws Exception {
    }
    private static void SetValue(Button button) throws IOException {
        Vector2 vector = new Vector2(Integer.parseInt(button.getId().split(" ")[0]),Integer.parseInt(button.getId().split(" ")[1]));
        but = button;
        vectorNow = vector;
        new GameController().OpenWindow();
    }
    public void OpenWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("number.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Sudoku / Number");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }
    public void OpenWindowWin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("win.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("You Winner!");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }
    public static void SetText(int number) throws IOException {
        if(number == 0){
            but.setText("");
        } else
        but.setText(number + "");
        nowPlace[vectorNow.x][vectorNow.y] = number;
        if(isThere()){
            new GameController().OpenWindowWin();
        }

    }
    private static boolean isThere(){
        for(int x = 0;x < 9;x++){
            for(int y = 0;y < 9;y++){
                if(place[x][y] != nowPlace[x][y]){
                    System.out.println("нет общего");
                    return false;
                }
            }
        }
        System.out.println("есть общее");
        return true;
    }
}
class Vector2{
    public int x;
    public int y;
    public Vector2(int x,int y){
        this.x = x;
        this.y = y;
    }
}