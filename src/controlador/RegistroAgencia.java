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
import modelo.dto.UsuarioAgenciaDTO;

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
		UsuarioAgenciaDTO dto = new UsuarioAgenciaDTO();
		AgenciaDTO aDto = new AgenciaDTO();
		/*---------UsuarioAgenciaDTO--------*/
		String nombre;
		String usuario;
		String pass;
		String apellidos;
		/*---------AgenciaDTO---------------*/		
		String RazonSocial;
		String RFC;
		String cuenta;
		String clabe;
		String contacto_direccion;
		String contacto_telefono;
		String contacto_sitioweb;
		/*---------------------------------*/
		nombre = request.getParameter("nombreUsr");
		usuario = request.getParameter("usuarioNom");		
		pass = request.getParameter("pass");
		apellidos = request.getParameter("apellidos");
		
		RazonSocial = request.getParameter("raz_soc");
		RFC = request.getParameter("rfc");
		cuenta = request.getParameter("nocuenta");
		clabe = request.getParameter("clabe");
		contacto_direccion = request.getParameter("direccion");
		contacto_telefono = request.getParameter("telefonico");
		contacto_sitioweb = request.getParameter("website");
		
		dto.setNombre(nombre);
		dto.setUsuario(usuario);
		dto.setApellidos(apellidos);
		dto.setPass(pass);
		
		aDto.setRazonSocial(RazonSocial);
		aDto.setRFC(RFC);
		aDto.setCuenta(cuenta);
		aDto.setClabe(clabe);
		aDto.setContacto_direccion(contacto_direccion);
		aDto.setContacto_telefono(contacto_telefono);
		aDto.setContacto_sitioweb(contacto_sitioweb);
		try {
			del.crearUsuarioAgencia(dto);
			response.sendRedirect("index.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
