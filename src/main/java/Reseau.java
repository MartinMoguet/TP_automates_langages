import java.util.ArrayList;
import java.util.List;

public class Reseau {
    ArrayList<Itinéraire> itinerairesBus;
    List<Itinéraire> itinerairesTram;
    List<Itinéraire> itinerairesTrain;


    public Reseau(ArrayList<Itinéraire> itinerairesBus, List<Itinéraire> itinerairesTram, List<Itinéraire> itinerairesTrain){
        this.itinerairesBus = itinerairesBus;
        this.itinerairesTram = itinerairesTram;
        this.itinerairesTrain = itinerairesTrain;
    
    }

    @Override
    public String toString() {
        return "Itinéraires en bus" + this.itinerairesBus + "\n" + "Itinéraires en tram " + this.itinerairesTram + "\n" + "Itinéraires en train " + this.itinerairesTrain ;
    }
}