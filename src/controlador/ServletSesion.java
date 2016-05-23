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
		try {
            HttpSession sesion = request.getSession();
            SagraDelegate del = new SagraDelegate();
            UsuarioDTO dto = new UsuarioDTO();
            UsuarioDTO res;
            String userName = request.getParameter("txtUser");
            String pass = request.getParameter("txtPass");
            dto.setUsuario(userName);
            dto.setPass(pass);
            res = del.leerUsuario(dto);
            if (res != null) {
                if (dto.getPass().equals(res.getPass())) {
                    sesion.setAttribute("nombre", res.getNombre());
                    sesion.setAttribute("apell", res.getApellidos());
                    sesion.setAttribute("user", res.getUsuario());
                    try {
                        response.sendRedirect("inicio.jsp");
                    } catch (IOException ex) {
                       
                    }
                }

            } else {
                try {
                    response.sendRedirect("index.html");
                } catch (IOException ex) {
                   
                }
            }

        } catch (SQLException ex) {
           
        }
	}

}
