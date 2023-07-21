package controlador.servlet.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.implementacion.CapacitacionController;
import modelo.entity.Capacitacion;


/**
 * Servlet implementation class ServletCrudCapacitaciones
 */
@WebServlet("/ServletCrudCapacitaciones")
public class ServletCrudCapacitaciones extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String option = request.getParameter("option"); 
		
	    CapacitacionController capacitacionController = new CapacitacionController();
	    String url = "login.jsp";
	    
	    switch (option) {
	    
	    	case "deleteCapacitacion": {
	    		int identificadorDelete = Integer.parseInt(request.getParameter("identificador"));

	    		capacitacionController.deleteCapacitacionByIdentificador(identificadorDelete);
	    		url = "listarcapacitaciones.jsp";
	    		request.setAttribute("capacitaciones", capacitacionController.findAllCapacitaciones());
	    		break;
	    	}
	      
	    	case "formUpdateCapacitacion" : {

	    		int idFormCapacitacion = Integer.parseInt(request.getParameter("identificador"));

	    		Capacitacion capacitacion = capacitacionController.findByIdentificadorCapacitacion(idFormCapacitacion);

	    		url = "capacitacion.jsp";

	    		request.setAttribute("capacitacion", capacitacion);
	    		break;
	    	}
	      
	    	case "updateCapacitacion" : {

	    		int identificador = Integer.parseInt(request.getParameter("identificador"));
	    		int rut = Integer.parseInt(request.getParameter("rut"));
	    		String dia = request.getParameter("dia");
	    		String hora = request.getParameter("hora");
	    		String lugar  = request.getParameter("lugar");
	    		String duracion  = request.getParameter("duracion");
	    		int cantidadAsistentes = Integer.parseInt(request.getParameter("cantidadAsistentes"));
	        
	    		Capacitacion updateCapacitacion = new Capacitacion(
	    				identificador, rut, dia, hora, lugar, duracion, cantidadAsistentes);
	    		
	    		capacitacionController.updateCapacitacion(updateCapacitacion);
	    		url = "listarcapacitaciones.jsp";
	    		request.setAttribute("capacitaciones", capacitacionController.findAllCapacitaciones());
	    		break;
	    	}

	    	case "saveCapacitacion" : {

	    		int rut = Integer.parseInt(request.getParameter("rut"));
	    		String dia = request.getParameter("dia");
	    		String hora = request.getParameter("hora");
	    		String lugar  = request.getParameter("lugar");
	    		String duracion  = request.getParameter("duracion");
	    		int cantidadAsistentes = Integer.parseInt(request.getParameter("cantidadAsistentes"));
	        
	    		Capacitacion saveCapacitacion = new Capacitacion(
	    				0, rut, dia, hora, lugar, duracion, cantidadAsistentes);
	    		
	    		capacitacionController.saveCapacitacion(saveCapacitacion);
	    		url = "crearcapacitacion.jsp";
	    		break;
	    	}

	    	default:
	    		break;
	        
	    }
	    // fin switch
	    request.getRequestDispatcher(url).forward(request, response);
	    
	  }

}
