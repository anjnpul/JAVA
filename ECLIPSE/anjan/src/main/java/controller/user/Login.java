package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DataAccess;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Connection conn = null;
		conn = DataAccess.getConnection();

		if (request.getParameter("login") != null) {
			PrintWriter out = response.getWriter();
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			try {
				if (user != null) {
					String Query = "select * from user where user=? and pass=?";
					PreparedStatement psm = conn.prepareStatement(Query);
					psm.setString(1, user);
					psm.setString(2, pass);
					ResultSet rs = psm.executeQuery();
					if (rs.next()) {
						out.print("Welcome, " + user);
						HttpSession session = request.getSession(true);
						session.setAttribute("user", user);
						session.setMaxInactiveInterval(30 * 60);
						response.sendRedirect("DataEntry.jsp");
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("login.html");
						out.println("<font color=red>Either user name or password is wrong.</font>");
						rd.include(request, response);
					}
				}
			} catch (Exception ex) {
				out.println(ex.getMessage());
			}
		} else if (request.getParameter("logout") != null) {
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession(false);
			session.removeAttribute("user");
			session.getMaxInactiveInterval();
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			out.println("<font color=red>Logged Out Successfully!</font>");
			rd.include(request, response);
		}
	}
}
