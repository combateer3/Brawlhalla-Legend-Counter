package pieChart;

import driver.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import legends.LegendHandler;

import java.util.ArrayList;

/**
 * Created by Scott on 8/20/2016.
 */
public class PieChartController {

    @FXML
    private PieChart pieChart;

    @FXML
    private Label label;

    private static LegendHandler legendHandler;

    public PieChartController() {

    }

    @FXML
    private void initialize() {
        legendHandler = Main.getLegendHandler();

        //pie chart data
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(createPieChartData());
        pieChart.setData(pieData);

        //show percent on click
        for (PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    e -> {
                        double total = 0;
                        for (PieChart.Data d : pieChart.getData()) {
                            total += d.getPieValue();
                        }
                        label.setTranslateX(e.getSceneX());
                        label.setTranslateY(e.getSceneY());
                        label.setText(String.format("%.1f%%", 100 * data.getPieValue() / total));
                    });
        }
    }

    private ArrayList<PieChart.Data> createPieChartData() {
        ArrayList<PieChart.Data> data = new ArrayList<>();

        //convert games into percentages
        float total = 0;

        for (int games : legendHandler.getLegendGames().values()) {
            total += games;
        }

        //cant divide by zero
        if (total == 0) {
            throw new ArithmeticException("Can't divide by zero");
        } else {
            for (String legend : legendHandler.getLegends()) {
                float games = legendHandler.getLegendGames().get(legend);
                float percent = (games / total) * 100;

                if (percent != 0) {
                    data.add(new PieChart.Data(legend, games / total));
                }
            }
        }

        return data;
    }

}
