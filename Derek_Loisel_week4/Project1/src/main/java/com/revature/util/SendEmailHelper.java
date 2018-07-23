package com.revature.util;

//import java.util.*;
//import javax.mail.*;
//import javax.mail.internet.*;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailHelper {

   public static void sendEmail(String from, String to, String username2, String password2) {    
     
	   
//	  // Assuming you are sending email from localhost
//      String host = "localhost";
//
//      // Get system properties
//      Properties properties = System.getProperties();
//      //set users id and pass
////      properties.setProperty("mail.user", "djloisel19@gmail.com");
////      properties.setProperty("mail.password", "ILoveMyFamily1919");
//      
//      // Setup mail server
//      properties.setProperty("mail.smtp.host", host);
//
//      // Get the default Session object.
//      Session session = Session.getDefaultInstance(properties);
//
//      try {
//         // Create a default MimeMessage object.
//         MimeMessage message = new MimeMessage(session);
//
//         // Set From: header field of the header.
//         message.setFrom(new InternetAddress(from));
//
//         // Set To: header field of the header.
//         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//         // Set Subject: header field
//         message.setSubject("Your revERS Manager Account was created!");
//
//         // Now set the actual message
//         message.setText("Your revERS Manager account has been created.  Please log in and change your password as soon as possible. \n Username: " + username + "\n Password: " + password);
//
//         
//         // Send message
//         Transport.send(message);
//         System.out.println("Sent message successfully....");
//      } catch (MessagingException mex) {
//         mex.printStackTrace();
//      }
	   
	   
	   

	   		final String username = from;
	   		final String password = "ILoveMyFamily1919";

	   		Properties props = new Properties();
	   		props.put("mail.smtp.auth", "true");
	   		props.put("mail.smtp.starttls.enable", "true");
	   		props.put("mail.smtp.host", "smtp.gmail.com");
	   		props.put("mail.smtp.port", "587");

	   		Session session = Session.getInstance(props,
	   		  new javax.mail.Authenticator() {
	   			protected PasswordAuthentication getPasswordAuthentication() {
	   				return new PasswordAuthentication(username, password);
	   			}
	   		  });

	   		try {

	   			Message message = new MimeMessage(session);
	   			message.setFrom(new InternetAddress(from));
	   			message.setRecipients(Message.RecipientType.TO,
	   				InternetAddress.parse(to));
	   			message.setSubject("Your revERS Manager Account was created!");
	   			message.setText("Your revERS Manager account has been created. \n Username: " + username2 + "\n Password: " + password2);

	   			Transport.send(message);

	   			System.out.println("Email sent");

	   		} catch (MessagingException e) {
	   			throw new RuntimeException(e);
	   		}
	   	
	   
   }
}