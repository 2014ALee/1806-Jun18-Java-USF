package ers.run.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import ers.run.util.LoadInfoHelper;

@WebServlet("*.loadinfo")
public class LoadInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to front controller, LoadInfoServlet.doGet()");
		
		Object info = new LoadInfoHelper().process(req, resp);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(info);
		System.out.println(json.toString());
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		pw.write(json);
	}

}