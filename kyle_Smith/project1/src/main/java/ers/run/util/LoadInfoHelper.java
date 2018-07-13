package ers.run.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ers.run.models.Reimbursment;
import ers.run.models.User;
import ers.run.models.UserReimbursments;
import ers.run.services.ErsService;

public class LoadInfoHelper {

	public Object process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with LoadInfoHelper: " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/fs-bank-demo/home.loadinfo":
			ErsService service = new ErsService();
			HttpSession session = req.getSession();
			User sessionUser = (User) session.getAttribute("user");
			sessionUser.setPassword("***************");
			ArrayList<Reimbursment> sessionUserAccounts = service.getReimbursmentsByAuthor(sessionUser.getUserId());
			UserReimbursments homeInfo = new UserReimbursments(sessionUser, sessionUserAccounts);
			
			return homeInfo;
			
		default:
			return null;
		}
	}
}