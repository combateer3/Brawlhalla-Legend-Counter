package driver;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import legends.LegendHandler;

import java.io.IOException;

public class MainController {

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private Label gamesLabel;

    private static LegendHandler legendHandler;

    public MainController() {

    }

    @FXML
    private void initialize() {
        legendHandler = Main.getLegendHandler();

        choiceBox.setItems(legendHandler.getLegends());
        choiceBox.setValue(legendHandler.getLegends().get(0));

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
        int games = legendHandler.getLegendGames().get(currentLegend);
        games += 1;

        legendHandler.getLegendGames().put(currentLegend, games);
        updateLabel(currentLegend);
    }

    @FXML
    private void subtractGame() {
        String currentLegend = (String) choiceBox.getValue();
        int games = legendHandler.getLegendGames().get(currentLegend);

        //can't go below zero
        if (games > 0){
            games -= 1;

            legendHandler.getLegendGames().put(currentLegend, games);
            updateLabel(currentLegend);
        }
    }

    @FXML
    private void clearGames() {
        for (String legend : legendHandler.getLegends()) {
            legendHandler.getLegendGames().put(legend, 0);
            updateLabel(legend);
        }
    }

    @FXML
    private void openPieChart() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/pieChart/pieChart.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setTitle("Pie Chart");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
