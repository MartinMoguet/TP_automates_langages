import java.util.List;

public class Ligne {
    private String transport;
    private Double num_ligne;
    private List <Station> listStation;

    public Ligne(String transport, Double num_ligne, List<Station> stations) { {
        this.transport = transport;
        this.num_ligne = num_ligne;
        this.listStation = stations;
    }
    }
    @Override
    public String toString() {
        return transport + ", Ligne n°" + num_ligne + ", Stations desservies "+ listStation ;
    }
}


