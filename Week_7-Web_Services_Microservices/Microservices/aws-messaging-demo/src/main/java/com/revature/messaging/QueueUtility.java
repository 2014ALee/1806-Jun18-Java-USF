package com.revature.messaging;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

public class QueueUtility {

	private BasicAWSCredentials awsCredentials = new BasicAWSCredentials(
			System.getenv("MESSAGING_ACCESS_KEY"), 
			System.getenv("MESSAGING_SECRET_ACCESS_KEY"));
	
	private AmazonSQS sqsClient = AmazonSQSClient.builder()
			.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
			.withRegion(System.getenv("MESSAGING_REGION"))
			.build();
	
	private final String QUEUE_URL = System.getenv("MESSAGING_QUEUE_URL");
	
	// Ideally we would pass in a parameter to determine which queue to poll from
	public ReceiveMessageResult poll() {
		ReceiveMessageRequest messageRequest = new ReceiveMessageRequest(QUEUE_URL);
		messageRequest.setVisibilityTimeout(15);
		ReceiveMessageResult message = sqsClient.receiveMessage(messageRequest);
		System.out.println(message.getMessages());
		return message;
	}
	
	public void deleteMessage(String receiptHandle) {
		DeleteMessageRequest deleteRequest = new DeleteMessageRequest(QUEUE_URL, receiptHandle);
		sqsClient.deleteMessage(deleteRequest);
	}
}
