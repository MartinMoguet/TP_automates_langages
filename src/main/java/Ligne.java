import java.util.List;

public class Ligne {
    private String transport;
    private Double num_ligne;
    private List <Station> listStation;
    private List <Itinéraire> listItinéraires;

    public Ligne(String transport, Double num_ligne, List<Station> stations, List<Itinéraire> itinéraires) { {
        this.transport = transport;
        this.num_ligne = num_ligne;
        this.listStation = stations;
        this.listItinéraires = itinéraires;
    }
    }
    @Override
    public String toString() {
        return transport + ", Ligne n°" + num_ligne + ", Stations desservies "+ listStation + ", Horaires" + listItinéraires ;
    }
}


