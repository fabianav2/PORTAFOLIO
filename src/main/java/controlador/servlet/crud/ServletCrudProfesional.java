package controlador.servlet.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.implementacion.ProfesionalController;
import controlador.implementacion.UsuarioController;
import modelo.entity.Profesional;
import modelo.entity.Usuario;

/**
 * Servlet implementation class ServletCrudProfesional
 */
@WebServlet("/ServletCrudProfesional")
public class ServletCrudProfesional extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String option = request.getParameter("option"); 
		
		ProfesionalController profesionalController = new ProfesionalController();
		UsuarioController usuarioController = new UsuarioController();
		
	    String url = "login.jsp";
	    
	    switch (option) {
	    
	    	case "deleteProfesional": {
	    		int runDelete = Integer.parseInt(request.getParameter("run"));

	    		profesionalController.deleteProfesionalByRun(runDelete);
	    		url = "listadousuarios.jsp";
	    		request.setAttribute("profesionales", profesionalController.findAllProfesionales());
	    		break;
	    	}
	      	      
	    	case "updateProfesional" : {

	    		int run = Integer.parseInt(request.getParameter("run"));
	    		String titulo = request.getParameter("titulo");
	    		String fechaIngreso = request.getParameter("fechaingreso");

	    		Usuario usuario = usuarioController.findByRunUsuario(run);
	    		
	    		Profesional updateProfesional = new Profesional(
	    				usuario.getRunUsuario(),
	    				usuario.getNombreUsuario(),
	    				usuario.getFechaNacimientoUsuario(),
	    				usuario.getTipo(),
	    				run, titulo, fechaIngreso);
	    		
	    		profesionalController.updateProfesional(updateProfesional);
	    		
	    		url = "listadousuarios.jsp";
	    		request.setAttribute("usuarios", usuarioController.findAllUsuarios());
	    		break;
	    	}

	    	case "saveProfesional" : {

	    		int run = Integer.parseInt(request.getParameter("run"));
	    		String titulo = request.getParameter("titulo");
	    		String fechaIngreso = request.getParameter("fechaingreso");
	    		
	    		Usuario usuario = usuarioController.findByRunUsuario(run);
	    		
	    		Profesional saveProfesional = new Profesional(
	    				usuario.getRunUsuario(),
	    				usuario.getNombreUsuario(),
	    				usuario.getFechaNacimientoUsuario(),
	    				usuario.getTipo(),
	    				run, titulo, fechaIngreso);
	    		
	    		profesionalController.saveProfesional(saveProfesional);
	    		
	    		url = "listadousuarios.jsp";
	    		request.setAttribute("usuarios", usuarioController.findAllUsuarios());

	    		break;
	    	}

	    	default:
	    	break;
	        
	    }
	    // fin switch
	    request.getRequestDispatcher(url).forward(request, response);
	    
	  }

}
