package TelluriumProj.Tellurium.src.main.java.Tellurium.Tellurium;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestConfig {
	 
	public String login_url;
	public List<String> browserNames = new ArrayList<String> ();
	public TestConfig(String file) {
 
	  try {
 
		File fXmlFile = new File( file );
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
 
		Element config = (Element) doc.getDocumentElement();
		System.out.println("Root element :" + config.getNodeName());

		NodeList browsers = doc.getElementsByTagName("browser");
		for (int temp = 0; temp < browsers.getLength(); temp++) {
			 
			   Node browser = browsers.item(temp);
			   browserNames.add(browser.getTextContent()); 
		}
		login_url = getTagValue("login_url", config);
		System.out.println("-----------------------");
 
	  } catch (Exception e) {
		e.printStackTrace();
	  }
  }
 
  private static String getTagValue(String sTag, Element eElement) {
	NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
 
        Node nValue = (Node) nlList.item(0);
 
	return nValue.getNodeValue();
  }
 
}
