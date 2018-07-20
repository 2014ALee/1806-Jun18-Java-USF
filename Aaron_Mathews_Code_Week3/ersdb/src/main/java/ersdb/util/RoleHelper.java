package ersdb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ersdb.models.User;
import ersdb.services.ERSService;

public class RoleHelper {
	
	public Object process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("[LOG] - Request sent to RoleHelper.process();");
		ERSService service = new ERSService();
		switch(req.getRequestURI()) {
		case "/ersdb/changeRole.userrole":
			
			BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
			
			String json = "";
			
			if (br != null) {
				json = br.readLine();
			}
			ObjectMapper mapper = new ObjectMapper();
			String[] roleInfo = mapper.readValue(json, String[].class);
			System.out.println(roleInfo[0]);
			System.out.println(roleInfo[1]);
			int newRole = Integer.parseInt(roleInfo[0]);
			int userid = Integer.parseInt(roleInfo[1]);
			
			User temp = service.getUserById(userid);
			temp.setRoleid(newRole);
			temp = service.updateRoleId(temp);
			return temp;
		default:
			return null;
		}
	}

}
