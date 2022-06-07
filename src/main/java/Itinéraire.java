public class Itinéraire {
    private Station depart;
    private Station arrivee;
    private Double horaire_depart;
    private Double horaire_arrivee;

    public Itinéraire(Station depart, Station arrivee, Double horaire_depart, Double horaire_arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.horaire_depart = horaire_depart;
        this.horaire_arrivee = horaire_arrivee;
    }

    @Override
    public String toString() {
        return "Départ " + this.depart + " à " + this.horaire_depart + "Arrivée " + this.arrivee + " à " + this.horaire_arrivee;
    }
}
