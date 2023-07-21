package controlador.servlet.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.implementacion.AdministrativoController;
import controlador.implementacion.ClienteController;
import controlador.implementacion.ProfesionalController;
import controlador.implementacion.UsuarioController;
import modelo.entity.Administrativo;
import modelo.entity.Cliente;
import modelo.entity.Profesional;
import modelo.entity.Usuario;

/**
 * Servlet implementation class ServletCrudUsuarios
 */
@WebServlet("/ServletCrudUsuarios")
public class ServletCrudUsuarios extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String option = request.getParameter("option"); 
	    String url = "login.jsp";
	    
	    UsuarioController usuarioController = new UsuarioController();
	    ClienteController clienteController = new ClienteController();
	    AdministrativoController administrativoController = new AdministrativoController();
	    ProfesionalController profesionalController = new ProfesionalController();
	    
	    switch (option) {
	    
	    	case "deleteUsuario": {
	    		int runDelete = Integer.parseInt(request.getParameter("run"));

	    		usuarioController.deleteUsuarioByRun(runDelete);
	    		clienteController.deleteClienteByRut(runDelete);
	    		administrativoController.deleteAdministrativoByRun(runDelete);
	    		profesionalController.deleteProfesionalByRun(runDelete);
	    		
	    		url = "listadousuarios.jsp";
	    		request.setAttribute("usuarios", usuarioController.findAllUsuarios());
	    		break;
	    	}
	      
	    	case "formUpdateUsuario" : {

	    		int runFormUsuario = Integer.parseInt(request.getParameter("run"));

	    		Usuario usuario = usuarioController.findByRunUsuario(runFormUsuario);

	    		url = "usuario.jsp";

	    		request.setAttribute("usuario", usuario);
	    		
	    		break;
	    	}
	      
	    	case "updateUsuario" : {

	    		int run = Integer.parseInt(request.getParameter("run"));
	    		String nombre  = request.getParameter("nombre");
	    		String fechaNacimiento  = request.getParameter("fechanacimiento");
	    		String tipo  = request.getParameter("tipo");
	    		
	    		Usuario updateUsuario = new Usuario(run,nombre,fechaNacimiento,tipo);
		
	    		usuarioController.updateUsuario(updateUsuario);
	    		
	    		switch (tipo) {
	    			case "cliente":
	    				url = "cliente.jsp";
	    				Cliente updateCliente = clienteController.findByRutCliente(run); 
	    				request.setAttribute("cliente", updateCliente);
	    				break;
	    			case "administrativo":
	    				url = "administrativo.jsp";
	    				Administrativo updateAdministrativo = administrativoController.findByRunAdministrativo(run);
	    				request.setAttribute("administrativo", updateAdministrativo);
	    				break;
	    			case "profesional":
	    				url = "profesional.jsp";
	    				Profesional updateProfesional = profesionalController.findByRunProfesional(run);
	    				request.setAttribute("profesional", updateProfesional);
	    				break;
	    			default:
	    				System.out.println("Ha ocurrido un error en el tipo de usuario");
	    		}
	    		request.setAttribute("accion", "update");
	    		break;
	    	}

	    	case "saveUsuario" : {
	    		
	    		int run = Integer.parseInt(request.getParameter("run"));
	    		String nombre  = request.getParameter("nombre");
	    		String fechaNacimiento  = request.getParameter("fechanacimiento");
	    		String tipo = request.getParameter("tipo");
	        
	    		Usuario saveUsuario = new Usuario(run, nombre,fechaNacimiento, tipo);
	    		
	    		usuarioController.saveUsuario(saveUsuario);
	    		
	    		switch (tipo) {
	    			case "cliente":
	    				url = "cliente.jsp";
	    				Cliente newCliente = new Cliente();
	    				newCliente.setRunUsuario(run);
	    				newCliente.setNombreUsuario(nombre);
	    				newCliente.setFechaNacimientoUsuario(fechaNacimiento);
	    				newCliente.setTipo(tipo);
	    				newCliente.setRutCliente(run);
	    				request.setAttribute("cliente", newCliente);
	    				break;
	    			case "administrativo":
	    				url = "administrativo.jsp";
	    				Administrativo newAdministrativo = new Administrativo();
	    				newAdministrativo.setRunUsuario(run);
	    				newAdministrativo.setNombreUsuario(nombre);
	    				newAdministrativo.setFechaNacimientoUsuario(fechaNacimiento);
	    				newAdministrativo.setTipo(tipo);
	    				newAdministrativo.setRun(run);
	    				request.setAttribute("administrativo", newAdministrativo);
	    				break;
	    			case "profesional":
	    				url = "profesional.jsp";
	    				Profesional newProfesional = new Profesional();
	    				newProfesional.setRunUsuario(run);
	    				newProfesional.setNombreUsuario(nombre);
	    				newProfesional.setFechaNacimientoUsuario(fechaNacimiento);
	    				newProfesional.setTipo(tipo);
	    				newProfesional.setRun(run);
	    				request.setAttribute("profesional", newProfesional);
	    				break;
	    			default:
	    				System.out.println("Ha ocurrido un error en el tipo de usuario");
	    		}
				request.setAttribute("accion", "save");
	    		break;
	    	}

	    	default:
	    		break;
	        
	    }
	    // fin switch
	    request.getRequestDispatcher(url).forward(request, response);
	    
	  }

}
