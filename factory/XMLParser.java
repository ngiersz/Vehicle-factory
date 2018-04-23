package factory;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class XMLParser {
	DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder;
	Document document;
	
	public XMLParser(String path) {
		try {
			dBuilder = builderFactory.newDocumentBuilder();
			document = dBuilder.parse(XMLReader.class.getResourceAsStream(path));
			document.normalize();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} 		
	}
	
	public int getNumberOf(String vehicleType) {
		return getNumberOfVehiclesInOrder(vehicleType, getOrder());
	}
	
	private int getNumberOfVehiclesInOrder(String vehicleType, NodeList order) {
		int count = 0;
		for(int i=0; i < order.getLength(); i++) {
			Node itemNode = order.item(i);
			Element item = (Element) itemNode;
			if(vehicleType.equals(item.getAttribute("type"))) 
				count++;
		}
		return count;
	}
	
	private NodeList getOrder() {
		NodeList orders = document.getElementsByTagName("order");
		Node rootNode = orders.item(0);
		Element rootElement = (Element)rootNode;
		NodeList order = rootElement.getElementsByTagName("item");
		return order;
	}	
}
