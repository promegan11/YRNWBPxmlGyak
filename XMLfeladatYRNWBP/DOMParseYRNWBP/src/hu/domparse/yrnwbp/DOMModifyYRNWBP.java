package hu.domparse.yrnwbp;

import java.io.*;
import java.text.ParseException;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import org.xml.sax.*;


public class DOMModifyYRNWBP {

			public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
		    XPathExpressionException, DOMException, ParseException {
				
				File xml = new File("src\\hu\\domparse\\yrnwbp\\XMLyrnwbp.xml");
				//StreamResult result = new StreamResult(new File("src\\\\hu\\\\domparse\\\\yrnwbp\\\\XMLyrnwbp.xml"));
				
		        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder builder = factory.newDocumentBuilder();
		        Document document = builder.parse(xml);

		        // a DOM document m�dos�t�sa
		        DomModifier.modifyDom(document);

		        // DOM document �talak�t�sa DOM DocumentTraversal form�ba
		        DocumentTraversal traversal = (DocumentTraversal) document;

		        //TreeWalker inicializ�l�sa
		        TreeWalker walker = traversal.createTreeWalker(document.getDocumentElement(),
		                NodeFilter.SHOW_ELEMENT | NodeFilter.SHOW_TEXT, null, true);

		        //DOM bej�r�sa
		        DomTraverser.traverseLevel(walker, "");
		        
		        

		        System.out.println("Done");
			}
			
		    private static class DomModifier {
		        public static void modifyDom(Document document) throws XPathExpressionException, DOMException, ParseException {
		            XPathFactory factory = XPathFactory.newInstance();
		            XPath xpath = factory.newXPath();

		            // 1.) Kiss Elem�r telefon sz�m�nak a megv�ltoztat�sa
		            Node owner = (Node) xpath.evaluate("//ugyfel[./nev='Kiss Elem�r']/tel",
		                    document, XPathConstants.NODE);

		            owner.setTextContent("06706311628");

		            // 2.) Minden rakt�ron olyan term�k 25% kedvezm�ny aminek a rakt�r k�szlete nagyobb 5 darabbn�l
		            NodeList termekek = (NodeList) xpath.evaluate("//termek[./raktkeszlet>5]/ar", document, XPathConstants.NODESET);
		            System.out.println(termekek);
		            for (int i = 0; i < termekek.getLength(); i++) {
		                Node termek = termekek.item(i);

		                double price = Double.parseDouble(termek.getTextContent());
		                termek.setTextContent(Double.toString(price * 0.80));
		            }
		            TransformerFactory transformerFactory = TransformerFactory.newInstance();
		            Transformer transformer;
					try {
						transformer = transformerFactory.newTransformer();
						DOMSource source = new DOMSource(document);
			            StreamResult result = new StreamResult(new File("src\\\\hu\\\\domparse\\\\yrnwbp\\\\XMLyrnwbp.xml"));
			            transformer.transform(source, result);
					} catch (TransformerConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		            
		        }
		    }

		    private static class DomTraverser {
		        public static void traverseLevel(TreeWalker walker, String indent) {
		            //aktu�lis csom�pont
		            Node node = walker.getCurrentNode();

		            if (node.getNodeType() == Node.ELEMENT_NODE) {
		                printElementNode(node, indent);
		            } else {
		                printTextNode(node, indent);
		            }

		            // rekurz�van megh�vjuk a bej�r�st a DOM f�ban
		            for (Node n = walker.firstChild(); n != null; n = walker.nextSibling()) {
		                traverseLevel(walker, indent + "    ");
		            }

		            walker.setCurrentNode(node);
		        }

		        private static void printElementNode(Node node, String indent) {
		            System.out.print(indent + node.getNodeName());

		            printElementAttributes(node.getAttributes());
		        }

		        private static void printElementAttributes(NamedNodeMap attributes) {
		            int length = attributes.getLength();

		            if (length > 0) {
		                System.out.print(" [ ");

		                for (int i = 0; i < length; i++) {
		                    Node attribute = attributes.item(i);

		                    System.out.printf("%s=%s%s", attribute.getNodeName(), attribute.getNodeValue(),
		                            i != length - 1 ? ", " : "");
		                }

		                System.out.println(" ]");
		            } else {
		                System.out.println();
		            }
		        }

		        private static void printTextNode(Node node, String indent) {
		            String content_trimmed = node.getTextContent().trim();

		            if (content_trimmed.length() > 0) {
		                System.out.print(indent);
		                System.out.printf("{ %s }%n", content_trimmed);
		            }
		        }
		    }

		}
