package cricBuzz.Database;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import cricBuzz.models.Overs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Database {

    public String team1 ="India";
    public String team2= "Australia";

    public HashMap<String, List<String>> getBattingOrderMapData() {
        HashMap<String, List<String>> battingOrderMap = new HashMap<String, List<String>>();
        battingOrderMap.put("Australia", new ArrayList<>(List.of("Steve Smith", "David Warner", "Adam Gilchrist","Ricky Ponting", "Shane Warne")) );
        battingOrderMap.put("India", new ArrayList<>(List.of("MS Dhoni", "Rohit Sharma", "Suresh Raina","Hardik Pandya", "Jasprit Bumrah")));

        return battingOrderMap;
    }

    public HashMap<String, List<String>> getBowlingOrderMapData() {
        HashMap<String, List<String>> bowlingOrderMap = new HashMap<String, List<String>>();
        bowlingOrderMap.put("Australia", new ArrayList<>(List.of("Shane Warne","Ricky Ponting","Adam Gilchrist", "Steve Smith", "David Warner")) );
        bowlingOrderMap.put("India", new ArrayList<>(List.of("Hardik Pandya", "Jasprit Bumrah", "Rohit Sharma","MS Dhoni", "Suresh Raina")));

        return bowlingOrderMap;
    }

    public List<Overs> getAllOvers() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader userJson = new JsonReader(new FileReader("src/main/resources/data.json"));

        Overs[] userArray = gson.fromJson(userJson, Overs[].class);
        return Arrays.asList(userArray);
    }
}
