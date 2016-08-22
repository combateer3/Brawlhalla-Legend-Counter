package pieChart;

import driver.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import legends.LegendHandler;

import java.util.ArrayList;

/**
 * Created by Scott on 8/20/2016.
 */
public class PieChartController {

    @FXML
    private PieChart pieChart;

    private static LegendHandler legendHandler;

    public PieChartController() {

    }

    @FXML
    private void initialize() {
        legendHandler = Main.getLegendHandler();

        //pie chart data
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(createPieChartData());
        pieChart.setData(data);
    }

    private ArrayList<PieChart.Data> createPieChartData() {
        ArrayList<PieChart.Data> data = new ArrayList<>();

        //convert games into percentages
        int total = 0;

        for (int games : legendHandler.getLegendGames().values()) {
            total += games;
        }

        //cant divide by zero
        if (total == 0) {
            throw new ArithmeticException("Can't divide by zero");
        } else {
            for (String legend : legendHandler.getLegends()) {
                int games = legendHandler.getLegendGames().get(legend);
                data.add(new PieChart.Data(legend, games / total));
            }
        }

        return data;
    }

}
