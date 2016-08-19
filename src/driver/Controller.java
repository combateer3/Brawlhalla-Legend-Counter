package driver;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import legends.LegendHandler;

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
        choiceBox.setItems(legendHandler.getLegends());
        choiceBox.setValue(legendHandler.getLegends().get(0));

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                updateLabel((int) newValue);
            }
        });

        //intial update since default selection isn't a change
        updateLabel(choiceBox.getValue().toString());
    }

    @FXML
    private void addGame() {
        String currentLegend = (String) choiceBox.getValue();
        int games = legendHandler.getLegendGames().get(currentLegend);
        games += 1;
        legendHandler.getLegendGames().put(currentLegend, games);
        updateLabel(currentLegend);
    }

    @FXML
    private void subtractGame() {
        String currentLegend = (String) choiceBox.getValue();
        int games = legendHandler.getLegendGames().get(currentLegend);
        games -= 1;
        legendHandler.getLegendGames().put(currentLegend, games);
        updateLabel(currentLegend);
    }

    private void updateLabel(int index) {
        String currentLegend = legendHandler.getLegends().get(index);
        int games = legendHandler.getLegendGames().get(currentLegend);
        gamesLabel.setText(games + " Games played");
    }

    private void updateLabel(String currentLegend) {
        int games = legendHandler.getLegendGames().get(currentLegend);
        gamesLabel.setText(games + " Games played");
    }

}
