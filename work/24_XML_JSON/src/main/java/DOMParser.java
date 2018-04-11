import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DOMParser {
    public static void main(String[] args) {

        try {
            File inputFile = new File("/home/pushkar/Desktop/IDEA_PROJECTS/XML_JSON/src/main/java/employee.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("employee");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Employee Code is : " + eElement.getAttribute("empC"));
                    System.out.println(
                            "First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println(
                            "Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println(
                            "Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Marks : " + eElement.getElementsByTagName("marks").item(0).getTextContent());


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}