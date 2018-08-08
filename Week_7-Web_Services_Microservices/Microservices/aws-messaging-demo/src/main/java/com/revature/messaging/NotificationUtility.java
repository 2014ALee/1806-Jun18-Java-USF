package com.revature.messaging;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

public class NotificationUtility {
	
	private BasicAWSCredentials awsCredentials = new BasicAWSCredentials(
			System.getenv("MESSAGING_ACCESS_KEY"), 
			System.getenv("MESSAGING_SECRET_ACCESS_KEY"));
	
	private AmazonSNS snsClient = AmazonSNSClient.builder()
			.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
			.withRegion(System.getenv("MESSAGING_REGION"))
			.build();
	
	/*
	 * Publishes a message to our SNS topic. Ideally we could have a properties file link topics to their respective
	 * ARN, and have the topic passed as a parameter here.
	 */
	public void publish(String message) {
		System.out.println(System.getenv("MESSAGING_TOPIC_ARN"));
		
		PublishRequest pubRequest = new PublishRequest(System.getenv("MESSAGING_TOPIC_ARN"), message);
		PublishResult pubResult = snsClient.publish(pubRequest);
		
		System.out.println("Message ID: " + pubResult.getMessageId());	
	}

}
