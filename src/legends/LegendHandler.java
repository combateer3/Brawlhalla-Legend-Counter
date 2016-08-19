package legends;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Scott on 8/19/2016.
 */
public class LegendHandler {

    private List<String> legendArray = new ArrayList<String>();
    private HashMap<String, Integer> legendGames = new HashMap<String, Integer>();

    public LegendHandler() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/legends/legends.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                //split legends and games
                String[] split = line.split(" ");

                //get legend name (for names with more than one word)
                String legend = "";
                for (int i = 0; i < split.length - 1; i++) {
                    legend += split[i] + " ";
                }

                legendArray.add(legend);
                legendGames.put(legend, Integer.parseInt(split[split.length - 1]));
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<String> getLegends() {
        return FXCollections.observableArrayList(legendArray);
    }

    public HashMap<String, Integer> getLegendGames() {
        return legendGames;
    }
}
