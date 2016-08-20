package legends;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Scott on 8/19/2016.
 */
public class LegendHandler {

    private List<String> legendArray;
    private HashMap<String, Integer> legendGames;

    private File file;

    public LegendHandler() {
        try {
            file = new File("data/legends.dat");

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            legendArray = (List<String>) ois.readObject();
            legendGames = (HashMap<String, Integer>) ois.readObject();

            ois.close();
        } catch (EOFException e) {
            legendArray = new ArrayList<>();
            legendGames = new HashMap<>();

            readFromTextFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveGames() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(legendArray);
            oos.writeObject(legendGames);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromTextFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/legends.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");

                String name = "";
                for (int i = 0; i < split.length - 1; i++) {
                    name += split[i] + " ";
                }

                legendArray.add(name);
                legendGames.put(name, Integer.parseInt(split[split.length - 1]));
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
