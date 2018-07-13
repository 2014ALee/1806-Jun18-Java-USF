package ersdb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ersdb.util.RequestViewHelper;

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to front controller, LoadViewServlet.doGet");
		
		String nextView = new RequestViewHelper().process(req, res);
		System.out.println(nextView);
		
		req.getRequestDispatcher(nextView).forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
