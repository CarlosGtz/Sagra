package controlador;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import modelo.SagraDelegate;
import modelo.dto.AutoDTO;

/**
 * Servlet implementation class UpdaterAuto
 */
@WebServlet("/UpdaterAuto")
public class UpdaterAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;

	private String filePath;
	private int maxFileSize = 200 * 1024;
	private int maxMemSize = 32 * 1024;
	private File file;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdaterAuto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		isMultipart = ServletFileUpload.isMultipartContent(request);
		filePath = request.getServletContext().getRealPath("/img/");
		String[] datosDTO = new String[9];
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("/home/carlos"));// cambiar al generar el war por /img/
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);
		try {

			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();
			int j = 0;
			while (i.hasNext()) {

				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					// Write the file
					file = new File(filePath + "/" + datosDTO[2]);
					System.out.println(filePath);
					fi.write(file);
				} else {
					
					datosDTO[j] = fi.getString();
					j++;
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			;
			System.out.println(ex);
		}

		SagraDelegate del = new SagraDelegate();
		AutoDTO dto = new AutoDTO();

		HttpSession sesion = request.getSession();
		dto.setRFCAgencia((String) sesion.getAttribute("RFCagencia"));
		dto.setId(datosDTO[0]);
		dto.setModelo(datosDTO[1]);
		dto.setPlacas(datosDTO[2]);
		dto.setColor(datosDTO[3]);
		dto.setMarca(datosDTO[4]);
		dto.setAño(datosDTO[5]);
		dto.setNumeroPasajeros(datosDTO[6]);
		dto.setTipo(datosDTO[7]);
		dto.setCosto(datosDTO[8]);
		System.out.println(dto);

		
			try {
				del.actualizarAuto(dto);
				response.sendRedirect("inicioAgencia.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
