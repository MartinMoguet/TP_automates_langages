public class Itinéraire {
    private Station depart;
    private Station arrivee;
    private String horaire_depart;
    private String horaire_arrivee;
    String dureeTrajet;

    public Itinéraire(Station depart, Station arrivee, String horaire_depart, String horaire_arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.horaire_depart = horaire_depart;
        this.horaire_arrivee = horaire_arrivee;
    }
    public Itinéraire(Station depart, Station arrivee, String dureeTrajet) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.dureeTrajet = dureeTrajet;
    }
    
    public boolean equals(Station depart, Station arrivee) {
        return (this.depart.equals(depart) && this.arrivee.equals(arrivee));
    }

    @Override
    public String toString() {
        return "Départ : " + this.depart + " à " + this.horaire_depart + " - Arrivée : " + this.arrivee + " à " + this.horaire_arrivee;
    }
}
