import java.io.FileReader;
import java.io.Reader;
import java.time.LocalTime;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class BusReader {
    public static void main(String[] args) throws Exception {
        /*JSONArray a = (JSONArray) .parse(new FileReader("c:\\exer4-courses.json"));

        for (Object o : a)
        {
          JSONObject person = (JSONObject) o;
      
          String name = (String) person.get("name");
          System.out.println(name);
      
          String city = (String) person.get("city");
          System.out.println(city);
      
          String job = (String) person.get("job");
          System.out.println(job);
      
          JSONArray cars = (JSONArray) person.get("cars");
      
          for (Object c : cars)
          {
            System.out.println(c+"");
          }
        }
       
       
        / // parsing file "JSONExample.json"
        Object ob = new JSONParser().parse(new FileReader("bdd/bus.json"));

        // typecasting ob to JSONObject
        JSONObject js = (JSONObject) ob;

        String firstName = (String) js.get("station");
        //String lastName = (String) js.get("lastName");

        System.out.println("First name is: " + firstName);
        //System.out.println("Last name is: " +lastName);*/


        ArrayList<Station> stations = new ArrayList<>();
        ArrayList<Itinéraire> itineraires = new ArrayList<>();
       
        try (Reader reader = new FileReader("bdd/bus.json")) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // Récupération des horaires
            JSONArray horaires = (JSONArray) jsonObject.get("horaires");
            for (JSONObject horaire : (Iterable<JSONObject>) horaires) {

                // Récupération des stations
                JSONArray stationsJson = (JSONArray) horaire.get("stations");
                stations.clear();

                for (JSONObject station : (Iterable<JSONObject>) stationsJson){
                    stations.add(new Station(station.get("station").toString()));
                }

                // Récupération des heures de passages
                JSONArray passages = (JSONArray) horaire.get("passages");
                for (JSONArray passage : (Iterable<JSONArray>) passages){
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
        System.out.println(itineraires);
    }
    }
}
