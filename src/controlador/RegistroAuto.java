package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.SagraDelegate;
import modelo.dto.AutoDTO;

/**
 * Servlet implementation class RegistroAuto
 */
@WebServlet("/RegistroAuto")
public class RegistroAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroAuto() {
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
		AutoDTO dto = new AutoDTO();
		String modelo = request.getParameter("modelo");
		String placas =  request.getParameter("placas");
		String color = request.getParameter("color");
		String marca =  request.getParameter("marca");
		String año = request.getParameter("anio");;
		String numeroPasajeros = request.getParameter("numero");
		String tipo = request.getParameter("tipo");
		
		dto.setModelo(modelo);
		dto.setPlacas(placas);
		dto.setColor(color);
		dto.setMarca(marca);
		dto.setAño(año);
		dto.setNumeroPasajeros(numeroPasajeros);
		dto.setTipo(tipo);
		
		try {
			del.crearAuto(dto);
			response.sendRedirect("inicioAgencia.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
