package modelo.facade;

import java.sql.Connection;
import java.sql.SQLException;

import modelo.dao.UsuarioAgenciaDAO;
import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioAgenciaDTO;

public class UsuarioAgenciaFacade {
	private Connection cnn;
    private UsuarioAgenciaDAO dao;
    
    public UsuarioAgenciaFacade(Connection cnn) {
        this.cnn = cnn;
        dao = new UsuarioAgenciaDAO();
    }
    
    public int crear(UsuarioAgenciaDTO dto) throws SQLException {
         return dao.create(dto, cnn);
    }

}
