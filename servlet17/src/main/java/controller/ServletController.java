package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blogpostdto.BlogPostObj;
import servicelayerfactory.ServiceLayerFactory;
import servicelayer.IBlogPostService;

@WebServlet("/servletcontroller/*")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestURI = request.getRequestURI();
		IBlogPostService blogPostService = null;
		PrintWriter out = response.getWriter();
		if (requestURI.endsWith("addform")) {
			BlogPostObj blogPostObj = new BlogPostObj();

			blogPostObj.setTitle(request.getParameter("title"));
			blogPostObj.setDescription(request.getParameter("description"));
			blogPostObj.setContent(request.getParameter("content"));

			blogPostService = ServiceLayerFactory.getBlogPostService();

			String message = blogPostService.addBlogPost(blogPostObj);

			if (message.equalsIgnoreCase("success"))
				out.println("<body><center><h1 style='color:GREEN'>REGISTRATION SUCCESSFUL</h1></center></body>");
			else
				out.println("<body><center><h1 style='color:RED'>REGISTRATION FAILED</h1></center></body>");
		}
		if (requestURI.endsWith("searchform")) {

			blogPostService = ServiceLayerFactory.getBlogPostService();

			ArrayList<BlogPostObj> blogPostArrayList = blogPostService.searchBlogPost();
			out.println("<body>");
			out.println("<center>");
			out.println("<table border='1'>");
			out.println("<tr><th>TITLE</th>"+"<th>DESCRIPTION</th>"+"<th>SADDRESS</th>"+"</tr>");
			for (BlogPostObj blogPostObj : blogPostArrayList) {
				if (blogPostObj.getMessage() != null && blogPostObj.getMessage().equalsIgnoreCase("success")) {
					out.println("<tr><td>" + blogPostObj.getTitle() + "</td>");
					out.println("<td>" + blogPostObj.getDescription() + "</td>");
					out.println("<td>" + blogPostObj.getContent() + "</td></tr>");
				} else
					out.println("<body><center><h1 style='color:RED'>RECORDS ARE NOT AVAILABLE"
							+ "</h1></center></body>");
			}
			System.out.println(blogPostArrayList);
			out.println("</table>");
			out.println("</center>");
			out.println("</body>");
		}
	}
}
