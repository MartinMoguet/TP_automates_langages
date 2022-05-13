public class Itinéraire {
    private Station Depart;
    private Station Arrivee;
    private String horaire_depart;
    private String horaire_arrivee;

    public Itinéraire(Station depart, Station arrivee, String horaire_depart, String horaire_arrivee) {
        Depart = depart;
        Arrivee = arrivee;
        this.horaire_depart = horaire_depart;
        this.horaire_arrivee = horaire_arrivee;
    }
}
