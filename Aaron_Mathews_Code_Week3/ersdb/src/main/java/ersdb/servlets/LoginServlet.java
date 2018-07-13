package ersdb.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import ersdb.models.User;
import ersdb.services.ERSService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to LoginServlet.doPost();");
		
		ERSService service = new ERSService();
		
		//Get received json data from req
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		
		if (br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		User temp = (service.getUserByUsername(username).getUserid() != 0) ? service.getUserByUsername(username) : null;
		
		if (temp == null) {
			System.out.println("[LOG] - Temporary user is null in LoginServlet.");
		} else if (!temp.getPassword().equals(password)) {
			temp = null;
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);
		}
		
		PrintWriter writer = res.getWriter();
		res.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		writer.write(userJSON);
	}

	
}
