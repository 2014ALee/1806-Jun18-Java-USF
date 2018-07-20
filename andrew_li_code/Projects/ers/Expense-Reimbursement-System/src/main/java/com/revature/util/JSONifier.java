package com.revature.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.models.ERSUser;
import com.revature.models.ReimbursementRequest;

public class JSONifier {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode json = mapper.createObjectNode();
		json.put("hello", "Hello");
		try {
			System.out.println(mapper.writeValueAsString(mapper.writeValueAsString(new ObjectNode[] {
					json, json, json, json, json
			})));
		} catch (JsonProcessingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			System.out.println(mapper.writeValueAsString(json));
			System.out.println(json);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String result = "";
		try {
			result = mapper.writeValueAsString("\"\"\"");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(("\"\"\""));
		System.out.println(result);
	}
	public static String ersUserToJSON(ERSUser ersUser) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode oNode = mapper.createObjectNode();
		oNode.put("id", ersUser.getId());
		oNode.put("username", ersUser.getUsername());
		oNode.put("email", ersUser.getEmail());
		oNode.put("firstname", ersUser.getFirstName());
		oNode.put("lastname", ersUser.getLastName());
		oNode.put("role", ersUser.getRole().getId());
		
		return mapper.writeValueAsString(oNode);
	}
	public static String reimbursementToJSON(ReimbursementRequest rreq) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode oNode = mapper.createObjectNode();
		oNode.put("reimbursementid", rreq.getReimbursementId());
		oNode.put("amount", BasicHelpers.toDollarString(rreq.getReimbursementAmount()));
		oNode.put("submitted", BasicHelpers.formatDate(rreq.getSubmitted()));
		oNode.put("status", rreq.getStatus().toString() + " " + BasicHelpers.formatDate(rreq.getResolved()));
		oNode.put("description", rreq.getDescription());
		oNode.put("author", ersUserToJSON(rreq.getAuthor()));
		oNode.put("rtype", rreq.getType().toString());
		return mapper.writeValueAsString(oNode);
	}
}
