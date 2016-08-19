package driver;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import legends.LegendHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private Label gamesLabel;

    LegendHandler legendHandler = new LegendHandler();

    public Controller() {

    }

    @FXML
    private void initialize() {
        //System.out.println("hi");
        choiceBox.setItems(legendHandler.getLegends());
        choiceBox.setValue(legendHandler.getLegends().get(0));
    }

    @FXML
    private void addGame() {

    }

    @FXML
    private void subtractGame() {

    }

}
