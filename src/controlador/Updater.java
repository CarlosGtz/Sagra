package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.SagraDelegate;
import modelo.dto.AgenciaDTO;
import modelo.dto.UsuarioAgenciaDTO;

/**
 * Servlet implementation class Updater
 */
@WebServlet("/Updater")
public class Updater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updater() {
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
		HttpSession sesion = request.getSession();
		/*---------UsuarioAgenciaDTO--------*/
		String nombre;
		String usuario;
		String pass;
		String apellidos;
		/*---------AgenciaDTO---------------*/
		String nombreEmp;
		String RazonSocial;
		String RFC;
		String cuenta;
		String clabe;
		String contacto_direccion;
		String contacto_telefono;
		String contacto_sitioweb;
		/*---------------------------------*/
		
		
		nombre = request.getParameter("usuarioNom");
		usuario = request.getParameter("usuarioEmp");		
		pass = request.getParameter("pass");
		apellidos = request.getParameter("apellidos");
		
		nombreEmp = request.getParameter("nombreEmp");
		RazonSocial = request.getParameter("raz_soc");
		RFC = request.getParameter("rfc");
		cuenta = request.getParameter("nocuenta");
		clabe = request.getParameter("clabe");
		contacto_direccion = request.getParameter("direccion");
		contacto_telefono = request.getParameter("telefono");
		contacto_sitioweb = request.getParameter("website");
		
		
		String rfcSesion = (String)sesion.getAttribute("RFCagencia");
		
		dto.setNombre(nombre);
		dto.setUsuario(usuario);
		dto.setApellidos(apellidos);
		dto.setPass(pass);
		dto.setRFCagencia(rfcSesion);
		
		aDto.setNombre(nombreEmp);
		aDto.setRazonSocial(RazonSocial);
		aDto.setRFC(rfcSesion);
		aDto.setCuenta(cuenta);
		aDto.setClabe(clabe);
		aDto.setContacto_direccion(contacto_direccion);
		aDto.setContacto_telefono(contacto_telefono);
		aDto.setContacto_sitioweb(contacto_sitioweb);
		sesion.setAttribute("RFCagencia", dto.getRFCagencia());
		
		try {
			del.actualizarAgencia(aDto, dto);
			response.sendRedirect("perfilAgencia.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
