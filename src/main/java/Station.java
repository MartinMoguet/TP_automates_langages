public class Station {
    String nom;

    public Station(String nom) {
        this.nom = nom;

    }

    @Override
    public String toString() {
        return "Station " + this.nom ;
    }
}
