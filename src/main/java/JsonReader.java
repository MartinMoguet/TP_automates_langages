import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadJson {

    List<Arret> arretList;

    public ReadJson(List<Arret> arretList) {
        this.arretList = arretList;
    }

    private void readJSON() {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("C:\\Users\\Basile\\IdeaProjects\\tpAutomateMaven\\src\\main\\resources\\bus.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject busList = (JSONObject) obj;
            parseBusTraj(busList);

        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

    }

    private void parseBusTraj(JSONObject bus) {
        Object ligne = bus.get("ligne");
        JSONArray horraires = (JSONArray) bus.get("horaires");
        horraires.forEach(direction -> {
            JSONObject d = (JSONObject) direction;
            System.out.println(d.get("passages"));
        });
    }

    public List<Arret> getArretList() {
        return arretList;
    }

    public void setArretList(List<Arret> arretList) {
        this.arretList = arretList;
    }

}