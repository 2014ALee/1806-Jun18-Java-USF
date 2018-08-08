package com.revature;

import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.revature.intercom.NotificationUtility;
import com.revature.intercom.QueueUtility;

public class MessagingDriver {

	public static void main(String[] args) {
//		NotificationUtility notificationUtil = new NotificationUtility();
//		notificationUtil.publish("Test message sent from a java app");
		
		QueueUtility queueUtil = new QueueUtility();
		ReceiveMessageResult message = queueUtil.poll();
		queueUtil.deleteMessage(message.getMessages().get(0).getReceiptHandle());
		
	}
}
