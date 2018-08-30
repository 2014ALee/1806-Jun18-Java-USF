package com.revature;

import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.revature.messaging.NotificationUtility;
import com.revature.messaging.QueueUtility;

public class MessagingDriver {
	public static void main(String[] args) {
//		NotificationUtility notifiicationUtil = new NotificationUtility();
//		notifiicationUtil.publish("Test message sent from a Java application!");
		
		QueueUtility queueUtil = new QueueUtility();
		ReceiveMessageResult message = queueUtil.poll();
		queueUtil.deleteMessage(message.getMessages().get(0).getReceiptHandle());
	}
}
