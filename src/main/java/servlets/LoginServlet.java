package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.Connect;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String email =(String) session.getAttribute("email");
		
		if("logout".equals(action))
		{
			session.invalidate();
			response.sendRedirect("login");
			return;
		}
		else if(email != null)
		{
			response.sendRedirect("profile");
			return;
		}
		else if("login".equals(action))
		{
			request.setAttribute("loginFailed", false); //login has not failed. user has not enetered credentails till now.
			request.getRequestDispatcher("/WEB-INF/jsps/view/login.jsp").forward(request, response);
			return;
		}
		else
		request.getRequestDispatcher("/WEB-INF/jsps/view/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email") != null)
		{
			response.sendRedirect("profile");
			return;
		}
		else if(email.isEmpty() || password.isEmpty() ||
				email == null || password == null
				)
		{
			session.setAttribute("loginFailed", true); //now the credentials are not correct.
			request.getRequestDispatcher("/WEB-INF/jsps/view/login.jsp").forward(request, response);
			return;
		}
		
		Connect connect = Connect.getInstance();
		
		PreparedStatement statement = connect.getPreparedStatement("SELECT * FROM USER WHERE EMAIL=\'" + email + "\' AND PASSWORD=\'" + password + "\';");
		
		try 
		{
			ResultSet rs = statement.executeQuery();
			
			if(!rs.next())
			{
				request.setAttribute("loginFailed", true); // Login has failed.
				request.getRequestDispatcher("/WEB-INF/jsps/view/login.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("email", email);
		response.sendRedirect("profile");
		return;
	}

}
