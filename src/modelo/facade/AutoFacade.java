package modelo.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import modelo.dao.AutoDAO;
import modelo.dto.AutoDTO;

public class AutoFacade {
	private Connection cnn;
    private AutoDAO dao;
    
    public AutoFacade(Connection cnn) {
        this.cnn = cnn;
        dao = new AutoDAO();
    }
    
    public int crear(AutoDTO dto) throws SQLException {
         return dao.create(dto, cnn);
    }
    
    public List listar() throws SQLException {
        return dao.selectAll(cnn);
    }
    
    public List listarXAgencia(AutoDTO dto)throws SQLException{
    	return dao.selectAllxAgecnia(dto,cnn);
    }
}
