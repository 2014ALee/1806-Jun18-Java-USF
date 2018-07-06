package com.revature.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AssociateHandler extends DefaultHandler {
	
	boolean bFirstName = false;
    boolean bLastName = false;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attr) throws SAXException {
        
        if(qName.equalsIgnoreCase("associate")) {
            String associateId = attr.getValue("id");
            System.out.println("Associate ID: " + associateId);
        } else if(qName.equalsIgnoreCase("firstName")) {
            bFirstName = true;
        } else if(qName.equalsIgnoreCase("lastName")) {
            bLastName = true;
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    
    }
    
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        
        if (bFirstName) {
            System.out.println("First Name: " + new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName) {
            System.out.println("Last Name: " + new String(ch, start, length));
            System.out.println("+---------------------------------------+");
            bLastName = false;
        }
    }
}
