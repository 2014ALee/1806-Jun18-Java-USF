package ersdb.util;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ersdb.models.Reimbursement;
import ersdb.models.User;
import ersdb.services.ERSService;

public class ReimbursementHelper {
	
	public Object process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ERSService service = new ERSService();
		HttpSession session = req.getSession();
		
		User sessionUser = (User) session.getAttribute("user");
		
		ArrayList<Reimbursement> reimbs = null;
		
		if (sessionUser.getRoleid() == 1 || sessionUser.getRoleid() == 2) {
			reimbs = service.getAllReimbursements();
		} else if (sessionUser.getRoleid() == 3) {
			reimbs = service.getReimbursementsByAuthor(sessionUser.getUserid());
		}
		
		return reimbs;
	}

}
