package es.udc.smunin.jreport.net;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import es.udc.smunin.jreport.wrappers.datamodels.Service;

/**
 * Singleton class which parses the received data from the servers. By now it
 * only supports the XML format.
 * 
 * @author Santiago Munín <santimunin@gmail.com>
 */
public class DataParser {
	/**
	 * Single instance of the class.
	 */
	private static DataParser instance = new DataParser();

	private DataParser() {
	}

	/**
	 * 
	 * @return the single instance of the class.
	 */
	public static DataParser getInstance() {
		return instance;
	}

	/**
	 * Parses a list of services.
	 * 
	 * @param rawXmlData
	 *            Services in XML.
	 * @return A list of service objects.
	 */
	public List<Service> parseServicesList(String rawXmlData) {
		DOMParser parser = new DOMParser();
		rawXmlData = rawXmlData.replaceAll("\\s*\n\\s*", "");

		List<Service> result = new ArrayList<Service>();
		try {
			parser.parse(new InputSource(new ByteArrayInputStream(rawXmlData
					.getBytes("utf-8"))));
			Document doc = parser.getDocument();
			NodeList list = doc.getElementsByTagName("service");
			for (int i = 0; i < list.getLength(); i++) {
				Node serviceNode = list.item(i);
				NodeList serviceFields = serviceNode.getChildNodes();

				String code = serviceFields.item(0).getFirstChild()
						.getNodeValue();
				boolean metadata = Boolean.valueOf(serviceFields.item(1)
						.getFirstChild().getNodeValue());
				String type = serviceFields.item(2).getFirstChild()
						.getNodeValue();
				String[] keywords = getKeywords(serviceFields.item(3));
				String group = serviceFields.item(4).getFirstChild()
						.getNodeValue();
				String name = serviceFields.item(5).getFirstChild()
						.getNodeValue();
				String description = serviceFields.item(6).getFirstChild()
						.getNodeValue();

				result.add(new Service(code, metadata, type, group, name,
						description, keywords));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// FIXME
			return result;
		}
		return result;
	}

	/**
	 * Transforms a comma separated list of keywords into to an array of
	 * strings. Used to parse the services.
	 * 
	 * @param keywordsNode
	 *            The keywords node.
	 * @return array of strings containing all the keywords.
	 */
	private String[] getKeywords(Node keywordsNode) {
		NodeList keywords = keywordsNode.getChildNodes();
		if (keywords.getLength() == 0) {
			return new String[] {};
		}
		String keywordsString = keywords.item(0).getNodeValue();
		String[] rawKeywords = keywordsString.split(",");
		String[] result = new String[rawKeywords.length];
		for (int i = 0; i < rawKeywords.length; i++) {
			result[i] = rawKeywords[i].trim();
		}
		return result;
	}
}
