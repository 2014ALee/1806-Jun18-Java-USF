package ersdb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ersdb.services.ERSService;

public class ValidationHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("[LOG] - Processing request with ValidationHelper: " + req.getRequestURI());
		
		ERSService service = new ERSService();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		
		if(br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		switch(req.getRequestURI()) {
		case "/ersdb/email.validate":
			String email = mapper.readValue(json, String.class);
			
			if(service.emailAvailable(email)) {
				return email;
			} else {
				return null;
			}
			
		case "/ersdb/username.validate":
			String username = mapper.readValue(json, String.class);
			
			if(service.unameAvailable(username)) {
				return username;
			} else {
				return null;
			}
			
		default:
			return null;
		}
	}
}
