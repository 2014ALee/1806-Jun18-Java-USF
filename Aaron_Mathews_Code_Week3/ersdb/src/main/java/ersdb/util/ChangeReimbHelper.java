package ersdb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import ersdb.models.Reimbursement;
import ersdb.models.User;
import ersdb.services.ERSService;

public class ChangeReimbHelper {

	public Object process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("[LOG] - Request sent to ChangeReimbHelper.process();");
		ERSService service = new ERSService();
		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("user");
		switch(req.getRequestURI()) {
		case "/ersdb/changeStatus.reimb":
			
			BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
			String json = "";
			if (br != null) {
				json = br.readLine();
			}
			ObjectMapper mapper = new ObjectMapper();
			String[] reimbInfo = mapper.readValue(json, String[].class);
			System.out.println(reimbInfo[0]);
			System.out.println(reimbInfo[1]);
			int newStatus = Integer.parseInt(reimbInfo[0]);
			int reimbid = Integer.parseInt(reimbInfo[1]);
			
			Reimbursement temp = service.getReimbursementById(reimbid);
			temp.setStatusId(newStatus);
			temp.setResolver(sessionUser.getUserid());
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			temp.setResolved(sqlDate);
			temp = service.resolveReimbursement(temp);
			return temp;
		default:
			return null;
		}
	}
	
}
