package com.revature;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.revature.util.AssociateHandler;

public class SAXParserDriver {

	public static void main(String[] args) {

		try {
			
			SAXParserFactory spFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = spFactory.newSAXParser();

			AssociateHandler associateHandler = new AssociateHandler();
			saxParser.parse("src/main/resources/associates.xml", associateHandler);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
