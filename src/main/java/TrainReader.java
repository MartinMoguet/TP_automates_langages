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

public class TrainReader {
    public static List<Itinéraire> trainReader(String path) throws ParserConfigurationException, SAXException 
    { 
        try {
            File file = new File(path);
            List<Itinéraire> itineraires = new ArrayList<>();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("junction");

            for (int j = 0; j < nList.getLength(); j++) {
                Node nNode = nList.item(j);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;                    
                    String station_depart = eElement.getElementsByTagName("start-station").item(0).getTextContent();
                    String station_arrivee = eElement.getElementsByTagName("arrival-station").item(0).getTextContent();
                    String horaire_depart = eElement.getElementsByTagName("start-hour").item(0).getTextContent();
                    String horaire_arrivee = eElement.getElementsByTagName("arrival-hour").item(0).getTextContent();
                    Station depart;
                    Station arrivee;
                    depart = new Station(station_depart);
                    arrivee= new Station(station_arrivee);
                    itineraires.add(new Itinéraire(depart, arrivee, horaire_depart, horaire_arrivee));
                }
            }
            return itineraires ;
        }
        catch(IOException e) {
            System.out.println(e);
        }
        return null;
    }
}
