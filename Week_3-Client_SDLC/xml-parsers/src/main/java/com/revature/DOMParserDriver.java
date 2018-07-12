package com.revature;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParserDriver {

public static void main(String[] args) {
        
        try {
            
            File batchXML = new File("src/main/resources/associates.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(batchXML);
            
            doc.getDocumentElement().normalize();
            
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            
            NodeList associateList = doc.getElementsByTagName("associate");
            
            for(int i = 0; i < associateList.getLength(); i++) {
                
                Node associatesNode = associateList.item(i);
                //System.out.println("Current element: " + associatesNode.getNodeName());
                
                if(associatesNode.getNodeType() == Node.ELEMENT_NODE) {
     
                    Element associateElement = (Element) associatesNode;
                    
                    System.out.println("Associate ID: " + associateElement.getAttribute("id"));
                    System.out.println("First Name: " + associateElement.getElementsByTagName("firstName").item(0).getTextContent());
                    System.out.println("Last Name: " + associateElement.getElementsByTagName("lastName").item(0).getTextContent());
                    
                }
                
                System.out.println("+-----------------------------+");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

}
