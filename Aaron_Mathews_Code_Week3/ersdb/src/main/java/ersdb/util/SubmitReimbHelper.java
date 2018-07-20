package ersdb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import ersdb.models.Reimbursement;
import ersdb.models.User;
import ersdb.services.ERSService;

public class SubmitReimbHelper {
	
	public Object process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ERSService service = new ERSService();
		HttpSession session = req.getSession();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		
		if (br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		String[] reimbInfo = mapper.readValue(json, String[].class);
		
		int type = Integer.parseInt(reimbInfo[0]);
		double amount = Double.parseDouble(reimbInfo[1]);
		String description = reimbInfo[2];
		
		User sessionUser = (User) session.getAttribute("user");
		
		Reimbursement reimb = null;
		
		if (sessionUser.getRoleid() != 1) {
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			int id = sessionUser.getUserid();
			
			System.out.println("Submitting to db");
			reimb = new Reimbursement(0, amount, sqlDate, null, description, null, id, 0, 1, type);
			reimb = service.createReimbursement(reimb);
		}
		
		return reimb;
	}

}
