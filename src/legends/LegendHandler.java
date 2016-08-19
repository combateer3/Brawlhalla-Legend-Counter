package legends;

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

    private List<String> legends = new ArrayList<String>();
    private HashMap<String, Integer> legendMap;

    public LegendHandler() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/legends/legends.txt"));
            String line = reader.readLine();
            if (line != null) {
                legends.add(line);
            } else {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getLegends() {
        return legends;
    }
}
