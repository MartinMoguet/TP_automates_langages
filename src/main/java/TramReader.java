import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TramReader {
    public static void main(String[] args) throws ParserConfigurationException, SAXException 
    { 
        try {
            File file = new File("bdd/tram.xml");
            List<Itinéraire> itineraires = new ArrayList<>();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("ligne");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    
                    //On lit et garde en mémoire les lignes de données du fichier
                    String station = eElement.getElementsByTagName("stations").item(0).getTextContent();
                    ArrayList<String> heures_passage = new ArrayList<>();
                    for (int j=0; j<eElement.getElementsByTagName("heures-passage").getLength(); j++){
                        heures_passage.add(eElement.getElementsByTagName("heures-passage").item(j).getTextContent());
                    }
                    
                    //On sépare les données
                    ArrayList<String> stations = new ArrayList<>();
                    stations = splitString(station);

                    ArrayList<ArrayList<String>> heuresPassage = new ArrayList<>();
                    for (int j=0; j<heures_passage.size(); j++){
                        heuresPassage.add(splitString(heures_passage.get(j)));
                    }
                    
                    //On vérifie que les 2 listes aient la même taille
                    if (heuresPassage.get(0).size()!=stations.size()){
                        System.out.println("On a un problème de taille là"); 
                    } ;
                    //On associe les paires départs/arrivées
                    for (int j=0; j<stations.size()-1; j++){
                        Station depart = new Station(stations.get(j));
                        Station arrivee = new Station(stations.get(j+1));
                        for(int k=0; k<heuresPassage.size();k++){
                            itineraires.add(new Itinéraire(depart, arrivee, heuresPassage.get(k).get(j), heuresPassage.get(k).get(j+1)));
                        } 
                    }
                }
            }
            for (Itinéraire itin : itineraires) System.out.println(itin.toString());
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
    public static ArrayList<String> splitString(String chaineCaracteres){
        String space =" ";
        String mot="";
        ArrayList<String> listeMots = new ArrayList<>();
        for (int i=0; i<chaineCaracteres.length(); i++ ){
            if (chaineCaracteres.charAt(i) != space.charAt(0)){
                mot = mot + chaineCaracteres.charAt(i);
            }
            else{
                listeMots.add(mot);
                mot="";
            }
        }
        listeMots.add(mot); //Pour le dernier mot qui n'est pas suivi d'espace
        return listeMots ;
    }
    
}
