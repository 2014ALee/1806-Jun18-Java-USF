package ers.run.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import ers.run.models.Reimbursment;
import ers.run.models.User;
import ers.run.services.ErsService;

@WebServlet("/updateReim")
public class updateReimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("got to updateReimServlet");
		ErsService ersService = new ErsService();
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = req.getSession();
		
		if(req.getInputStream() != null) {
			System.out.println("got to updateReimServlet if " + session.getAttribute("user"));
			Reimbursment reim = mapper.readValue(req.getInputStream(), Reimbursment.class);
			User user = (User) session.getAttribute("user");
			reim.setResolved(new java.sql.Date(new Date().getTime()));
			reim.setResolver(user.getUserId());
			System.out.println(reim.getSubmitted());
			boolean updated = ersService.updateReim(reim);
			System.out.println("got to updateReimServlet boolean = " + updated);
		
			if (updated) {
				PrintWriter pw = resp.getWriter();
				resp.setContentType("application/json");
				String reimJSON = mapper.writeValueAsString(reim);
				System.out.println("got to updateReimServlet " + reimJSON);
				pw.write(reimJSON);
			}
		}
	}

}
