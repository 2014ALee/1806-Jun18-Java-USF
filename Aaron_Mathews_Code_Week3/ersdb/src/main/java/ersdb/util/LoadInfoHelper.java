package ersdb.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ersdb.models.User;
import ersdb.services.ERSService;

public class LoadInfoHelper {

	public Object process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("[LOG] - Processing request with LoadInfoHelper: " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/ersdb/homepage.loadinfo":
			ERSService service = new ERSService();
			
			HttpSession session = req.getSession();
			User sessionUser = (User) session.getAttribute("user");
			sessionUser.setPassword("***************");
//			System.out.println(sessionUser.toString());
//			ArrayList<Re> sessionUserAccounts = service.getUserAccounts(sessionUser);
//			UserAccounts homeInfo = new UserAccounts(sessionUser, sessionUserAccounts);
			
			return sessionUser;
			
		default:
			return null;
		}
	}
}
