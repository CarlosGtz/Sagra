package modelo.facade;

import java.sql.Connection;
import java.sql.SQLException;

import modelo.dao.AgenciaDAO;
import modelo.dto.AgenciaDTO;

public class AgenciaFacade {
	private Connection cnn;
    private AgenciaDAO dao;
    
    public AgenciaFacade(Connection cnn) {
        this.cnn = cnn;
        dao = new AgenciaDAO();
    }
    
    public int crear(AgenciaDTO dto) throws SQLException {
        return dao.create(dto, cnn);
   }
    public AgenciaDTO leer(AgenciaDTO dto)throws SQLException{
    	return dao.select(dto, cnn);
    }
    
    public void actualizar(AgenciaDTO dto) throws SQLException{
    	dao.update(dto, cnn);
    }

}
