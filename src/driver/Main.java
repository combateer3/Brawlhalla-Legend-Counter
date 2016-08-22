package driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import legends.LegendHandler;

public class Main extends Application {

    private static LegendHandler legendHandler;

    @Override
    public void start(Stage primaryStage) throws Exception{
        legendHandler = new LegendHandler();

        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Brawlhalla Legend Counter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        legendHandler.saveGames();
    }

    public static LegendHandler getLegendHandler() {
        return legendHandler;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
