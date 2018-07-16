package ers.run.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

@WebServlet("/createReim")
public class createReimServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("got to createReimServlet");
		ErsService ersService = new ErsService();
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = req.getSession();
		
		if(req.getInputStream() != null) {
			System.out.println("got to createReimServlet if " + session.getAttribute("user"));
			Reimbursment reim = mapper.readValue(req.getInputStream(), Reimbursment.class);
			reim.setSubmitted(new java.sql.Date(new Date().getTime()));
			System.out.println(reim.getSubmitted());
			boolean created = ersService.createReim(reim, (User) session.getAttribute("user"));
			System.out.println("got to createReimServlet boolean = " + created);
		
			if (created) {
				PrintWriter pw = resp.getWriter();
				resp.setContentType("application/json");
				String reimJSON = mapper.writeValueAsString(reim);
				System.out.println("got to regServlet" + reimJSON);
				System.out.println("got to createReimServlet " + reimJSON);
				pw.write(reimJSON);
			}
		}
		
		
	}

}
