package in.sessioncontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionusername/*")
public class UserNameSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String requestURI=request.getRequestURI();
		String name=null;
		if(requestURI.endsWith("sessionusername/getUserName")) {
			name=(String)session.getAttribute("name");
			if(name==null) {
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("username.html");
				requestDispatcher.forward(request, response);
			}
			PrintWriter printWriter=response.getWriter();
			printWriter.println("<h1><center>Welcome "+ name +"</center></h1>");
		}
		if(requestURI.endsWith("sessionusername/setUserName")) {
			name=request.getParameter("name");
			session.setAttribute("name", name);
			
			PrintWriter printWriter=response.getWriter();
			printWriter.println("<h1><center>Welcome "+ name +"</center></h1>");
		}
	}

}
