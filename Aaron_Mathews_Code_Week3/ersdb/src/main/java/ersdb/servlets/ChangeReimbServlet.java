package ersdb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ersdb.util.ChangeReimbHelper;

@WebServlet("*.reimb")
public class ChangeReimbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to RoleServlet.doPost();");
		
		Object reimb = new ChangeReimbHelper().process(req, res);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimb);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		pw.write(json);
	}
}
