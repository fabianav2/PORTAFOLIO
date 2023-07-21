package controlador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Contacto
 */
@WebServlet("/ServletContacto")
public class ServletContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);// rescato la session
		String usuario=(String) session.getAttribute("usuario");
		
		if (usuario != null) {
			request.getRequestDispatcher("contacto.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// doGet(request, response);
		String nombre = request.getParameter("nombre");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String comentario = request.getParameter("comentario");
		
		despliegaDatosContacto(nombre,telefono,email,comentario);
		
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}
	
	private void despliegaDatosContacto(String nombre, String telefono, String email, String comentario) {
		  
		System.out.println("*****************");
		System.out.println("DATOS DE CONTACTO");
		System.out.println("*****************");
		System.out.println(nombre);
		System.out.println(telefono);
		System.out.println(email);
		System.out.println(comentario);
		System.out.println("*****************");
		  
	}

}
