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

import com.fasterxml.jackson.databind.ObjectMapper;

import ersdb.models.User;
import ersdb.services.ERSService;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to SignUpServlet.doPost();");
		
		ERSService service = new ERSService();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		
		if (br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		String[] userInfo = mapper.readValue(json, String[].class);
		String firstname = userInfo[0];
		String lastname  = userInfo[1];
		String username = userInfo[2];
		String email = userInfo[3];
		String pass = userInfo[4];
		
		User temp = new User();
		temp.setEmail(email);
		temp.setUsername(username);
		temp.setFirstname(firstname);
		temp.setLastname(lastname);
		temp.setPassword(pass);
		temp.setRoleid(3);
		temp.setUserid(0);
		
		temp = (service.createNewUser(temp).getUserid() != 0) ? service.getUserByUsername(username) : null;
		
		if (temp == null) {
			System.out.println("[LOG] - Temporay user is null in SignUpServlet");
		} else {
			System.out.println("[LOG] - Sign up successfull from SignUpServlet");
		}
		
		PrintWriter writer = res.getWriter();
		res.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		writer.write(userJSON);
	}
	
	

}
