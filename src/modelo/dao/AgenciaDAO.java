package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.dto.AgenciaDTO;

public class AgenciaDAO {
	private static final String SQL_INSERT = "insert into agencia (nombre,razon_social,RFC,cuenta,clabe,contacto_direccion,contacto_telefono,contacto_sitioweb)"+
			"values (?,?,?,?,?,?,?,?)";
	
	
	public int create(AgenciaDTO dto, Connection conn)throws SQLException{
		 PreparedStatement ps = null;
	        try {
	            ps = conn.prepareStatement(SQL_INSERT);
	            ps.setString(1, dto.getNombre());
	            ps.setString(2, dto.getRazonSocial());
	            ps.setString(3, dto.getRFC());
	            ps.setString(4, dto.getCuenta());
	            ps.setString(5, dto.getClabe());
	            ps.setString(6, dto.getContacto_direccion());
	            ps.setString(7, dto.getContacto_telefono());
	            ps.setString(8, dto.getContacto_sitioweb());
	                      
	            return ps.executeUpdate();
	        } finally {
	            cerrar(ps);
	            //cerrar(conn);
	        }
				
	}
	
	private void cerrar(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            }
        }
    }
	
	private void cerrar(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
    }
    private void cerrar(Connection cnn) {
        if (cnn != null) {
            try {
                cnn.close();
            } catch (SQLException e) {
            }
        }
    }

}
