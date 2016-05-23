package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.SagraDelegate;
import modelo.dto.UsuarioDTO;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/Registro")
public class RegistroUsurio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsurio() {
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
		String nombre;
	    String apellidos;
	    String usuario;
	    String email;
	    String pass;
	    SagraDelegate del = new SagraDelegate();
	    nombre = request.getParameter("nombre");
	    apellidos = request.getParameter("apellidos");
	    usuario = request.getParameter("usuario");
	    email = request.getParameter("email");
	    pass = request.getParameter("pass");
	    UsuarioDTO dto = new UsuarioDTO();
	    dto.setNombre(nombre);
	    dto.setApellidos(apellidos);
	    dto.setUsuario(usuario);
	    dto.setEmail(email);
	    dto.setPass(pass);
	    try {
			del.crearArticulo(dto);
			response.sendRedirect("index.html");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
