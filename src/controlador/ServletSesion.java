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
import modelo.dto.UsuarioAgenciaDTO;
import modelo.dto.UsuarioDTO;

/**
 * Servlet implementation class ServletSesion
 */
@WebServlet("/ServletSesion")
public class ServletSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSesion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession sesion = request.getSession();
			SagraDelegate del = new SagraDelegate();
			String flag = "";
			String userName = request.getParameter("txtUser");
			String pass = request.getParameter("txtPass");
			flag = request.getParameter("flag");
			if (!flag.equals("true") ) {// inicio sesion usuario
				UsuarioDTO dto = new UsuarioDTO();
				UsuarioDTO res;
				dto.setUsuario(userName);
				dto.setPass(pass);
				res = del.leerUsuario(dto);
				
				if (res != null) {
					
					if (pass.equals(res.getPass())) {
						
						sesion.setAttribute("user", userName);
						
						try {
							response.sendRedirect("inicio.jsp");
						} catch (IOException ex) {

						}
					}else {
						try {
							response.sendRedirect("index.html");
						} catch (IOException ex) {

						}

					}

				} else {
					try {
						response.sendRedirect("index.html");
					} catch (IOException ex) {

					}

				}
			} else {

				UsuarioAgenciaDTO dtoA = new UsuarioAgenciaDTO();
				UsuarioAgenciaDTO resA = null;
				dtoA.setUsuario(userName);
				dtoA.setPass(pass);
				resA = del.leerUsuarioAgencia(dtoA);
				if(dtoA.getPass().equals(pass)){
					sesion.setAttribute("RFCagencia", dtoA.getRFCagencia());
					try {
						response.sendRedirect("inicioAgencia.jsp");
					} catch (IOException ex) {

					}
				}else {
					try {
						response.sendRedirect("index.html");
					} catch (IOException ex) {

					}

				}				

			}

		} catch (SQLException ex) {		
				ex.printStackTrace();
				response.sendRedirect("index.html");			
		}
	}

}
