import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Double num_ligne = (double) 0 ;              
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("bdd/train.xml"));
        List<Ligne> lignes = new ArrayList<>();
        List<Station> stations = new ArrayList<>();
        List<Itinéraire> itineraires = new ArrayList<>();
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                String station_depart =  elem.getElementsByTagName("start-station").item(0).getChildNodes().item(0).getNodeValue();
                String station_arrivee =  elem.getElementsByTagName("arrival-station").item(0).getChildNodes().item(0).getNodeValue();
                Double horaire_depart = Double.parseDouble(elem.getElementsByTagName("start-hour").item(0).getChildNodes().item(0).getNodeValue());
                Double horaire_arrivee = Double.parseDouble(elem.getElementsByTagName("arrival-hour").item(0).getChildNodes().item(0).getNodeValue());
                //Double num_ligne = Double.parseDouble(elem.getElementsByTagName("line").item(0).getChildNodes().item(1).getNodeValue());
                num_ligne = num_ligne + 1 ;
                
                Station depart;
                Station arrivee;
                depart = new Station(station_depart);
                arrivee= new Station(station_arrivee);
                stations.add(depart);
                stations.add(new Station(station_arrivee));
                lignes.add(new Ligne("train", num_ligne, stations));
                itineraires.add(new Itinéraire(depart, arrivee, horaire_depart, horaire_arrivee));
            }
        }
        for (Ligne lign: lignes)
            System.out.println(lign.toString());
        for (Station stat : stations) System.out.println(stat.toString());
        for (Itinéraire itin : itineraires) System.out.println(itin.toString());

    }
    
}