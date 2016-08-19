package driver;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private TextField inputText;

    @FXML
    private TextArea outputText;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    public Controller() {

    }

    @FXML
    private void initialize() {

    }

    @FXML
    private void printOutput() {
        outputText.setText(inputText.getText());
    }

}
