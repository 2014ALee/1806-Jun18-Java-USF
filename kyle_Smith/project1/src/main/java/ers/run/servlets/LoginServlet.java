package ers.run.servlets;

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
import ers.run.models.User;

import ers.run.services.ErsService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to LoginServlet.doPost()");
		
		ErsService service = new ErsService();
		
		// 1) Get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		// 2) Initiate the Jackson object mapper (allow for conversion to and from Java objects to JSON)
		ObjectMapper mapper = new ObjectMapper();
		
		// 3) Convert received JSON to String array
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		System.out.println(username);
		System.out.println(password);
		System.out.println(service.getUserByUsername(username).getUserId());
		System.out.println(service.getUserByUsername(username).getUsername());
		User temp = new User();
		if(username.contains("@"))
			temp = (service.getUserByEmailAddress(username).getUserId() != 0) ? service.getUserByEmailAddress(username) : null;
		else
			temp = (service.getUserByUsername(username).getUserId() != 0) ? service.getUserByUsername(username) : null;
		
		if(temp == null) {
			System.out.println("[LOG] - Variable 'temp' in LoginServlet is null");
		} else if(!temp.getPassword().equals(password)) {
			temp.setUserId(0);
			temp.setFirstName(null);
			temp.setLastName(null);
			temp.setEmail(null);
			temp.setUsername(null);
			temp.setPassword(null);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", temp); // persists this user to the session
			System.out.println("[LOG] - in loginServlet " + session.getAttribute("user"));
		}
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		String userJSON = mapper.writeValueAsString(temp);
		pw.write(userJSON);
	}

}
