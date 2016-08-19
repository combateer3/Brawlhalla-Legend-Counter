package driver;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import legends.LegendHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private Label gamesLabel;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    LegendHandler legendHandler = new LegendHandler();

    public Controller() {

    }

    @FXML
    private void initialize() {
        //TODO add legends to choicebox
        //choiceBox.setItems(legendHandler.getLegends());
    }

    @FXML
    private void addGame() {

    }

    @FXML
    private void subtractGame() {

    }

}
