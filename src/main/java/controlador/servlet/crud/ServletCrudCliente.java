package controlador.servlet.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.implementacion.ClienteController;
import controlador.implementacion.UsuarioController;
import modelo.entity.Cliente;
import modelo.entity.Usuario;

/**
 * Servlet implementation class ServletCrudCliente
 */
@WebServlet("/ServletCrudCliente")
public class ServletCrudCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String option = request.getParameter("option"); 
		
	    ClienteController clienteController = new ClienteController();
	    UsuarioController usuarioController = new UsuarioController();
	    
	    String url = "login.jsp";
	    
	    switch (option) {
	    
	    	case "deleteCliente": {
	    		int runDelete = Integer.parseInt(request.getParameter("run"));

	    		clienteController.deleteClienteByRut(runDelete);
	    		
	    		url = "listadousuarios.jsp";
	    		request.setAttribute("usuarios", usuarioController.findAllUsuarios());
	    		break;
	    	}
	      	      
	    	case "updateCliente" : {

	    		int rut = Integer.parseInt(request.getParameter("rut"));
	    		String nombres  = request.getParameter("nombres");
	    		String apellidos  = request.getParameter("apellidos");
	    		String telefonos = request.getParameter("telefonos");
	    		String afp = request.getParameter("afp");
	    		int sistemaSalud = Integer.parseInt(request.getParameter("sistemasalud"));
	    		String direccion = request.getParameter("direccion");
	    		String comuna = request.getParameter("comuna");
	    		byte edad = Byte.parseByte(request.getParameter("edad"));
	    		
	    		Usuario usuario = usuarioController.findByRunUsuario(rut);
	    		
	    		Cliente updateCliente = new Cliente(
	    				usuario.getRunUsuario(),
	    				usuario.getNombreUsuario(),
	    				usuario.getFechaNacimientoUsuario(),
	    				usuario.getTipo(),
	    				rut,nombres,apellidos,telefonos,afp,sistemaSalud,direccion,comuna,edad);
	    		
	    		clienteController.updateCliente(updateCliente);
	    		
	    		url = "listadousuarios.jsp";
	    		request.setAttribute("usuarios", usuarioController.findAllUsuarios());
	    		break;
	    	}

	    	case "saveCliente" : {
	    		
	    		int rut = Integer.parseInt(request.getParameter("rut"));
	    		String nombres  = request.getParameter("nombres");
	    		String apellidos  = request.getParameter("apellidos");
	    		String telefonos = request.getParameter("telefonos");
	    		String afp = request.getParameter("afp");
	    		int sistemaSalud = Integer.parseInt(request.getParameter("sistemasalud"));
	    		String direccion = request.getParameter("direccion");
	    		String comuna = request.getParameter("comuna");
	    		byte edad = Byte.parseByte(request.getParameter("edad"));
	    		
	    		Usuario usuario = usuarioController.findByRunUsuario(rut); 
	        
	    		Cliente saveCliente = new Cliente(
	    				usuario.getRunUsuario(),
	    				usuario.getNombreUsuario(),
	    				usuario.getFechaNacimientoUsuario(),
	    				usuario.getTipo(),
	    				rut,nombres,apellidos,telefonos,afp,sistemaSalud,direccion,comuna,edad);
	    		
	    		clienteController.saveCliente(saveCliente);
	    		
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
