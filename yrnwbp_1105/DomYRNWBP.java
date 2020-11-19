package domyrnwbp;


import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



public class XpathParseYRNWBP {
	
	public static void main(String[] args) throws Exception 
    {
		 //Build DOM
    
	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
    Document doc = builder.parse("\\Git/YRNWBPxmlGyak/YRNWBPxml/studentYNRWBP.xml");

    //Create XPath

    XPathFactory xpathfactory = XPathFactory.newInstance();
    XPath xpath = xpathfactory.newXPath();
    
    //Create results
    XPathExpression expr = xpath.compile("//student/firstname/text()");
    Object result = expr.evaluate(doc, XPathConstants.NODESET);
    NodeList firstnames = (NodeList) result;
    expr = xpath.compile("//student/lastname/text()");
    result = expr.evaluate(doc, XPathConstants.NODESET);
    NodeList lastnames = (NodeList) result;
    expr = xpath.compile("//student/nickname/text()");
    result = expr.evaluate(doc, XPathConstants.NODESET);
    NodeList nicknames = (NodeList) result;
    expr = xpath.compile("//student/marks/text()");
    result = expr.evaluate(doc, XPathConstants.NODESET);
    NodeList marks = (NodeList) result;
    expr = xpath.compile("//student[@rollno]//*");
	result = expr.evaluate(doc, XPathConstants.NODESET);
	NodeList rootelem = (NodeList) result;
	expr = xpath.compile("//student[@rollno]/@rollno");
   	result = expr.evaluate(doc, XPathConstants.NODESET);
   	NodeList rollno = (NodeList) result;
    
    for (int i = 0; i < firstnames.getLength(); i++) {
    	
    	 System.out.println("Current Element : "+ rootelem.item(i).getParentNode().getNodeName());
    	 System.out.println(rootelem.item(i).getParentNode().getNodeName()+ " roll no : "+rollno.item(i).getNodeValue());
        System.out.println(firstnames.item(i).getParentNode().getNodeName() + " : "+firstnames.item(i).getNodeValue());
        System.out.println(lastnames.item(i).getParentNode().getNodeName() + " : "+lastnames.item(i).getNodeValue());
        System.out.println(nicknames.item(i).getParentNode().getNodeName() + " : "+nicknames.item(i).getNodeValue());
        System.out.println(marks.item(i).getParentNode().getNodeName() + " : "+marks.item(i).getNodeValue()+"\n");
    }

    }
	
}
