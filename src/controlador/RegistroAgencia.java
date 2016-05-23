package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.SagraDelegate;
import modelo.dto.AgenciaDTO;

/**
 * Servlet implementation class RegistroAgencia
 */
@WebServlet("/RegistroAgencia")
public class RegistroAgencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroAgencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SagraDelegate del = new SagraDelegate();
		AgenciaDTO dto = new AgenciaDTO();
		String nombre;
		String usuario;
		String email;
		String pass;
		nombre = request.getParameter("nombreEmp");
		usuario = request.getParameter("usuarioEmp");
		email = request.getParameter("email");
		pass = request.getParameter("pass");
		dto.setNombre(nombre);
		dto.setUsuario(usuario);
		dto.setEmail(email);
		dto.setPass(pass);
		try {
			del.crearUsuarioAgencia(dto);
			response.sendRedirect("index.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
