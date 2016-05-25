package modelo.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
    
    public UsuarioAgenciaDTO leer(UsuarioAgenciaDTO dto) throws SQLException{
    	return dao.select(dto, cnn);
    }
    public void actualizar(UsuarioAgenciaDTO dto)throws SQLException{
    	dao.update(dto, cnn);
    }
}
