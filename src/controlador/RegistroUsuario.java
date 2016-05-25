package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class RegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuario() {
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
	    String pass;
	    String email;
	    Date fecha_nacimiento;
	    String RFC;
	    String CURP;
	    String tarjeta_no;
	    String tarjeta_fechalim;
	    String tarjeta_codigo;
	    String cred_elector;
	    String contacto_telefono;
	    
	    
	    SagraDelegate del = new SagraDelegate();
	    nombre = request.getParameter("nombre");
	    apellidos = request.getParameter("apellidos");
	    email = request.getParameter("email");
	    usuario = request.getParameter("usuario");	
	    
	    pass = request.getParameter("pass");
	    RFC = request.getParameter("rfc");
	    CURP = request.getParameter("curp");
	    tarjeta_no = request.getParameter("notarjeta");
	    tarjeta_fechalim = request.getParameter("cadtarjeta");
	    tarjeta_codigo = request.getParameter("codtarjeta");
	    cred_elector = request.getParameter("ine");
	    contacto_telefono = request.getParameter("telefono");
	    try {
			fecha_nacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fec_nac"));
		    
	    
	    UsuarioDTO dto = new UsuarioDTO();
	    dto.setNombre(nombre);
	    dto.setApellidos(apellidos);
	    dto.setUsuario(usuario);
	    dto.setEmail(email);
	    dto.setPass(pass);
	    dto.setFecha_nacimiento(fecha_nacimiento);
	    dto.setRFC(RFC);
	    dto.setCURP(CURP);
	    dto.setTarjeta_no(tarjeta_no);
	    dto.setTarjeta_fechalim(tarjeta_fechalim);
	    dto.setTarjeta_codigo(tarjeta_codigo);
	    dto.setCred_elector(cred_elector);
	    dto.setContacto_telefono(contacto_telefono);
	    System.out.println(dto);
	    del.crearArticulo(dto);
		response.sendRedirect("index.html");
		
	    
	    } catch (ParseException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	   
	}

}
