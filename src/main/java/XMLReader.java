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
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("fichiers/train.xml"));
        List<Ligne> lignes = new ArrayList<>();
        List<Station> stations = new ArrayList<>();
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                String nom =  elem.getElementsByTagName("start-station").item(0).getChildNodes().item(0).getNodeValue();
                Double num_ligne = Double.parseDouble(elem.getElementsByTagName("salary").item(0).getChildNodes().item(0).getNodeValue());
                Double horaire_depart = Double.parseDouble(elem.getElementsByTagName("start-hour").item(0).getChildNodes().item(0).getNodeValue());
                Double horaire_arrive = Double.parseDouble(elem.getElementsByTagName("arrival-hour").item(0).getChildNodes().item(0).getNodeValue());
                stations.add(new Station(nom, horaire_depart, horaire_arrive));
                lignes.add(new Ligne("train", num_ligne, stations));
            }
        }
        for (Ligne lign: lignes)
            System.out.println(lign.toString());
    }
    
}