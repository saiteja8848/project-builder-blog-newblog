package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import model.User;

@WebServlet(urlPatterns = { "/blog" })
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BlogController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String blogDetails = request.getParameter("selectedAnswers");
		String[] data = blogDetails.split(",");
		LocalDate date = LocalDate.now();
		String blogTitle = data[0];
		String blogDescription = data[1];
		Blog blog = new Blog(blogTitle, blogDescription, date);
        User user =null;
       

System.out.println("Blog Title: "+blogTitle);
System.out.println("Blog Description: "+blogDescription);
System.out.println("Posted on: "+date);
        
		if (blog != null) {
			request.setAttribute("blog", blog);
			request.setAttribute("user", user);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}

	}

}
