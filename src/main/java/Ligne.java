import java.util.ArrayList;

public class Ligne {
    private String transport;
    private String horaire_depart;
    private String horaire_arrivee;
    private String num_ligne;
    private ArrayList <Station> listStation;

    public Ligne(String transport, String horaire_depart, String horaire_arrivee, String num_ligne, ArrayList <Station> listStation) { {
        this.transport = transport;
        this.horaire_depart = horaire_depart;
        this.horaire_arrivee = horaire_arrivee;
        this.num_ligne = num_ligne;
        this.listStation = listStation;
    }
    }}


