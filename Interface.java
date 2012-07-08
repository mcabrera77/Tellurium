package TelluriumProj;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Interface
{

	protected static String getStringValue(Element node, String sTag) {
		System.out.println("...SignIn looking for " + sTag);
		NodeList elemChilds = node.getChildNodes();
		for (int i = 0; i < elemChilds.getLength(); i++) {
		    Node itemChildNode = elemChilds.item(i);
		    if (!(itemChildNode instanceof Element))
		        continue;
			Element elemChild = (Element) itemChildNode;
			String elemName = elemChild.getNodeName();
			if (elemName.equals(sTag)) {
				System.out.println("...SignIn found " + elemName);
				return elemChild.getTextContent();
			}
		}
		System.out.println("...SignIn could not find " + sTag);
		return "";
    }
}
