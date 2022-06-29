import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.regex.Pattern;

public class InterCitesReader {
    /*public static void main(String[] args) throws FileNotFoundException {
        
        Boolean hours = false;
        ArrayList<Itinéraire> itineraires = new ArrayList<>();
        Station stationDepart;
        Station stationArrivee;
        String horaireDepart;
        String horaireArrivee;

        File file = new File("bdd/InterCites.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (Pattern.matches("//.*", line)) {
                hours = true;
            } else if (!Pattern.matches("%.*", line)) {
                if (hours) {
                    String[] elem = line.split("[ \t]+");
                    stationDepart = new Station(elem[0]);
                    stationArrivee = new Station(elem[1]);
                    horaireDepart = elem[2];
                    for (int i=0; i<itineraires.size() ; i++) {
                        if (itineraires.get(i).equals(stationDepart, stationArrivee) || itineraires.get(i).dureeTrajet != null) {
                            horaireArrivee = additionHeures(horaireDepart, itineraires.get(i).dureeTrajet);
                            Itinéraire nouvelItinéraire = new Itinéraire(stationDepart, stationArrivee, horaireDepart, horaireArrivee);
                            itineraires.add(nouvelItinéraire);
                        }
                    }
                } else {
                    String[] elem = line.split("[ \t]+");
                    stationDepart = new Station(elem[0]);
                    stationArrivee = new Station(elem[1]);
                    Itinéraire itin = new Itinéraire(stationDepart, stationArrivee, elem[2]);
                    itineraires.add(itin);
                }
            }
        }
        for (Itinéraire itin : itineraires) {
            if (itin.dureeTrajet == null) {
                itineraires.remove(itin);
            }
        }
        sc.close();
    }
    public static String additionHeures(String H, String minutes) {
        int minute = Integer.parseInt(minutes);
        int h = Integer.parseInt(H.substring(0, 2));
        int m = Integer.parseInt(H.substring(2, 4));
        int min = (m + minute) % 60;
        int heure = (h + (m + minute) / 60) % 24;
        return String.format("%02d%02d", heure, min);
    }*/
}