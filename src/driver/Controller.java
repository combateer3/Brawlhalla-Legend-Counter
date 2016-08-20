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

    public Controller() {

    }

    @FXML
    private void initialize() {
        LegendHandler.init();

        choiceBox.setItems(LegendHandler.getLegends());
        choiceBox.setValue(LegendHandler.getLegends().get(0));

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                updateLabel((int) newValue);
            }
        });

        //initial update since default selection isn't a change
        updateLabel(choiceBox.getValue().toString());
    }

    @FXML
    private void addGame() {
        String currentLegend = (String) choiceBox.getValue();
        int games = LegendHandler.getLegendGames().get(currentLegend);
        games += 1;
        LegendHandler.getLegendGames().put(currentLegend, games);
        updateLabel(currentLegend);
    }

    @FXML
    private void subtractGame() {
        String currentLegend = (String) choiceBox.getValue();
        int games = LegendHandler.getLegendGames().get(currentLegend);
        games -= 1;
        LegendHandler.getLegendGames().put(currentLegend, games);
        updateLabel(currentLegend);
    }

    @FXML
    private void clearGames() {
        //TODO clear games
    }

    private void updateLabel(int index) {
        String currentLegend = LegendHandler.getLegends().get(index);
        int games = LegendHandler.getLegendGames().get(currentLegend);
        gamesLabel.setText(games + " Games played");
    }

    private void updateLabel(String currentLegend) {
        int games = LegendHandler.getLegendGames().get(currentLegend);
        gamesLabel.setText(games + " Games played");
    }

}
