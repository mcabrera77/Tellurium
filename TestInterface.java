package TelluriumProj;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;




public class TestInterface {
	 
	public String baseUrl;
	public List<String> browserNames = new ArrayList<String> ();
	public TestInterface(String file) {
 
	  try {
 
		File fXmlFile = new File( file );
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
 
		Element Interface = (Element) doc.getDocumentElement();
		System.out.println("Document " + Interface.getNodeName());

		NodeList browsers = doc.getElementsByTagName("browser");
		for (int temp = 0; temp < browsers.getLength(); temp++) {
			 
			   Node browser = browsers.item(temp);
			   browserNames.add(browser.getTextContent()); 
		}
		baseUrl = getTagValue("baseUrl", Interface);
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
