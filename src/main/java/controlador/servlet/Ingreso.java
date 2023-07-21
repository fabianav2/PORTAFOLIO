package controlador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlador.implementacion.UserController;

/**
 * Servlet implementation class Ingreso
 */
@WebServlet("/Ingreso")
public class Ingreso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	  
	    UserController userController = new UserController();
	    String username = request.getParameter("username");
		String password = request.getParameter("password");
		String result = userController.login(username, password);
		
		if(!result.equals("false")) {
		  guardarCredenciales(username, password, response);
		  HttpSession session = request.getSession();
		  session.setAttribute("usuario",username);
		}

		response.setContentType("text/html; charset-UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();

	}

	private void guardarCredenciales(String username, String password, HttpServletResponse response) {
		  
		  Cookie cookie = new Cookie("credenciales", username);
		  cookie.setMaxAge(1000);
		  response.addCookie(cookie);
		  
	}

}
