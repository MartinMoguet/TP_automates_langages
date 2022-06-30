import java.io.FileReader;
import java.io.Reader;
import java.time.LocalTime;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class BusReader {
    public static ArrayList<Itinéraire> busReader(String path) throws Exception {

        ArrayList<Station> stations = new ArrayList<>();
        ArrayList<Itinéraire> itineraires = new ArrayList<>();
       
        try (Reader reader = new FileReader(path)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // Récupération des horaires
            JSONArray horaires = (JSONArray) jsonObject.get("horaires");
            for (JSONObject horaire : (Iterable<JSONObject>) horaires) {

                // Récupération des stations
                JSONArray stationsJson = (JSONArray) horaire.get("stations");
                stations.clear();

                for (JSONObject station : (Iterable<JSONObject>) stationsJson){
                  String s = station.get("station").toString();
                  try {
                    s.matches("[a-zA-Z]");
                  }catch(Exception e){
                    System.out.println("Le nom des stations ne doit être composé que de lettres");
                  }
                  stations.add(new Station(s));
                }

                // Récupération des heures de passages
                JSONArray passages = (JSONArray) horaire.get("passages");
                for (JSONArray passage : (Iterable<JSONArray>) passages){
                  String p = String.valueOf(passage);
                  try {
                    p.matches("\"[0-2][0-9][0-5][0-9]\",|\"[0-2][0-9][0-5][0-9]\"],$");
                  }catch(Exception e){
                    System.out.println("Ce n'est pas un format d'heure valide");
                  }
                    for (String heure : (Iterable<String>) passage){
                        if(passage.indexOf(heure) < passage.size() - 1) {
                            Station stationDepart = stations.get(passage.indexOf(heure));
                            Station stationArrive = stations.get(passage.indexOf(heure) + 1);
                            LocalTime heureDepart = LocalTime.parse(heure.substring(0, 2) + ":" + heure.substring(2, 4) + ":00");
                            LocalTime heureArrive = LocalTime.parse(((String) passage.get(passage.indexOf(heure) + 1)).substring(0, 2) + ":" + ((String) passage.get(passage.indexOf(heure) + 1)).substring(2, 4) + ":00");
                            String HD =String.valueOf(heureDepart);
                            String HA =String.valueOf(heureArrive);
                            itineraires.add(new Itinéraire(stationDepart, stationArrive, HD, HA));
                        }
                    }
                }
            }
        return itineraires;
    }
    }
}
