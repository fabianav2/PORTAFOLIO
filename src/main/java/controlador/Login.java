package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);// rescato la session		
		
		if (session != null) {
			session.invalidate();
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();// Obtengo la session
		
		if (usuario.equals("admin") && password.equals("1234")) {

			session.setAttribute("usuario", usuario);// creo la session usuario
			requestDispatcher = request.getRequestDispatcher("Inicio");
		}else {
			if (session != null) {
				session.invalidate();// Elimino la session si existe
			}
			requestDispatcher = request.getRequestDispatcher("login.jsp");
		}
		
		requestDispatcher.forward(request, response);
	}

}
