package TelluriumProj.Tellurium.src.main.java.Tellurium.Tellurium;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class TestPlan {
	 
	public String login_url;
	public TestPlan(TestConfig config, WebDriver driver, String file) {
		try {
			File fXmlFile = new File( file );
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc;
			doc = dBuilder.parse(fXmlFile);
//			doc.getDocumentElement().normalize();
			 
			Element testplan = (Element) doc.getDocumentElement();
			System.out.println("Root element :" + testplan.getNodeName());
			
			Run(config, driver, doc.getChildNodes());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Boolean Run(TestConfig config, WebDriver driver, NodeList tests) {
        Boolean result = Boolean.TRUE;
        try {
	        for (int i = 0; i < tests.getLength(); i++) {
	        	Boolean res = Boolean.TRUE;
	        	Node testNode = tests.item(i);
			    if (!(testNode instanceof Element))
			        continue;
			    
			    Element testElem = (Element) testNode;
	
	            String elem_name = testElem.getNodeName();//.getElementsByTagName("test_name").item(0)).getTextContent();
	            System.out.println(elem_name);

	            if (elem_name.equals("testplan")) {
	            	res = Run(config, driver, testElem.getChildNodes());
	            }
	            if (elem_name.equals("test")) {
	            	res = Run(config, driver, testElem.getChildNodes());
	            }
	            if (elem_name.equals("test_sign_in")) {
	            	res = SignIn.login(config, driver, testElem); 
	            }
	            if (elem_name.equals("test_upload_sbom")) {
	            	res = UploadBOM.UploadBOM(config, driver, testElem); 
	            }
	            if (elem_name.equals("test_sign_out")) {
	            	res = SignIn.logout(config, driver, testElem); 
	            }
	            if (res) {
	            	res = runRecursiveIfFound(config, driver, testElem, "on_pass");
	            } else {
	            	res = runRecursiveIfFound(config, driver, testElem, "on_fail");
	            }
	            result = result && res;
	            if (!result) break;
	        }
	        System.out.println("-----------------------");
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return result;
	}
 
    private Boolean runRecursiveIfFound(TestConfig config, WebDriver driver, Element node, String sTag) {
		System.out.println("...Recursive looking for " + sTag);
		NodeList elemChilds = node.getChildNodes();
		for (int i = 0; i < elemChilds.getLength(); i++) {
		    Node itemChildNode = elemChilds.item(i);
		    if (!(itemChildNode instanceof Element))
		        continue;
			Element elemChild = (Element) itemChildNode;
			String elemName = elemChild.getNodeName();
			if (elemName.equals(sTag)) {
				System.out.println("...Recursive found " + elemName);
				return Run(config, driver, elemChild.getChildNodes());
			}
		}
		System.out.println("...Recursive could not find " + sTag);
		return Boolean.TRUE;
    }

}
