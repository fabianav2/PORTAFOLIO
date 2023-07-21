package controlador.servlet.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.implementacion.AdministrativoController;
import controlador.implementacion.UsuarioController;
import modelo.entity.Administrativo;
import modelo.entity.Usuario;

/**
 * Servlet implementation class ServletCrudAdministrativo
 */
@WebServlet("/ServletCrudAdministrativo")
public class ServletCrudAdministrativo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String option = request.getParameter("option"); 
		
		AdministrativoController administrativoController = new AdministrativoController();
		UsuarioController usuarioController = new UsuarioController();
		
	    String url = "login.jsp";
	    
	    switch (option) {
	    
	    	case "deleteAdministrativo": {
	    		int runDelete = Integer.parseInt(request.getParameter("run"));

	    		administrativoController.deleteAdministrativoByRun(runDelete);
	    		
	    		url = "listadousuarios.jsp";
	    		request.setAttribute("usuarios", usuarioController.findAllUsuarios());
	    		break;
	    	}
	      
	    	case "updateAdministrativo" : {

	    		int run = Integer.parseInt(request.getParameter("run"));
	    		String area = request.getParameter("area");
	    		String aniosExperiencia = request.getParameter("aniosexperiencia");
	    		
	    		Usuario usuario = usuarioController.findByRunUsuario(run);
	    		
	    		Administrativo updateAdministrativo = new Administrativo(
	    				usuario.getRunUsuario(),
	    				usuario.getNombreUsuario(),
	    				usuario.getFechaNacimientoUsuario(),
	    				usuario.getTipo(),
	    				run, area, aniosExperiencia);
	    		
	    		administrativoController.updateAdministrativo(updateAdministrativo);
	    		url = "listadousuarios.jsp";
	    		request.setAttribute("usuarios", usuarioController.findAllUsuarios());
	    		break;
	    	}

	    	case "saveAdministrativo" : {
	    		
	    		int run = Integer.parseInt(request.getParameter("run"));
	    		String area = request.getParameter("area");
	    		String aniosExperiencia = request.getParameter("aniosexperiencia");
	    		
	    		Usuario usuario = usuarioController.findByRunUsuario(run);
	    		
	    		Administrativo saveAdministrativo = new Administrativo(
	    				usuario.getRunUsuario(),
	    				usuario.getNombreUsuario(),
	    				usuario.getFechaNacimientoUsuario(),
	    				usuario.getTipo(),
	    				run, area, aniosExperiencia);
	    		
	    		administrativoController.saveAdministrativo(saveAdministrativo);
	    		
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
