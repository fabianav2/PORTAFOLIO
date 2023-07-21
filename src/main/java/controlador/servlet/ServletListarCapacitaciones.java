package controlador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.implementacion.CapacitacionController;

/**
 * Servlet implementation class Capacitacion
 */
@WebServlet("/ServletListarCapacitaciones")
public class ServletListarCapacitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CapacitacionController capacitacionController = new CapacitacionController();
	    
	    request.setAttribute("capacitaciones", capacitacionController.findAllCapacitaciones());

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/listarcapacitaciones.jsp");
	    dispatcher.forward(request, response);
	  }
}
