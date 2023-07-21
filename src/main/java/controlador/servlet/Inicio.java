package controlador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cookie [] cookies = request.getCookies();
		  
		if(cookies != null) {
			
		    for(Cookie cookie: cookies) {
		    	
		    	if(cookie.getName().equals("credenciales")) {
		    		response.sendRedirect("inicio.jsp");
		    		return;
		    	}
		    }
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
