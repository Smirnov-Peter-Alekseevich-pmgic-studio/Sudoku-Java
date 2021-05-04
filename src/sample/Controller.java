package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Controller {
    public enum Difficulty{
        EASE,
        MIDDLE,
        HARD,
        UNREAL
    }
    Difficulty difficulty = Difficulty.EASE;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane MainWindow;

    @FXML
    private Label logoApp;

    @FXML
    private Button playButton;

    @FXML
    private CheckBox EaseDifficulty;

    @FXML
    private CheckBox MiddleDifficulty;

    @FXML
    private CheckBox HardDifficulty;

    @FXML
    private CheckBox UnrealDifficulty;

    @FXML
    private Label difficultyLabel;

    @FXML
    void initialize() throws IOException {
    }
    @FXML
    private void Play() throws IOException {
        Main.Play(difficulty);
    }
    @FXML
    private void SelectEase(){
        EaseDifficulty.setSelected(true);
        MiddleDifficulty.setSelected(false);
        HardDifficulty.setSelected(false);
        UnrealDifficulty.setSelected(false);
        difficulty = Difficulty.EASE;
    }
    @FXML
    private void SelectMiddle(){
        EaseDifficulty.setSelected(false);
        MiddleDifficulty.setSelected(true);
        HardDifficulty.setSelected(false);
        UnrealDifficulty.setSelected(false);
        difficulty = Difficulty.MIDDLE;
    }
    @FXML
    private void SelectHard(){
        EaseDifficulty.setSelected(false);
        MiddleDifficulty.setSelected(false);
        HardDifficulty.setSelected(true);
        UnrealDifficulty.setSelected(false);
        difficulty = Difficulty.HARD;
    }
    @FXML
    private void SelectUnreal() {
        EaseDifficulty.setSelected(false);
        MiddleDifficulty.setSelected(false);
        HardDifficulty.setSelected(false);
        UnrealDifficulty.setSelected(true);
        difficulty = Difficulty.UNREAL;
    }
}
