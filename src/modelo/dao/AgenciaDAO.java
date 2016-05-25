package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dto.AgenciaDTO;
import modelo.dto.UsuarioAgenciaDTO;

public class AgenciaDAO {
	private static final String SQL_INSERT = "insert into agencia (nombre,razon_social,RFC,cuenta,clabe,contacto_direccion,contacto_telefono,contacto_sitioweb)"+
			"values (?,?,?,?,?,?,?,?)";
	private static final String SQL_SELECT = "Select * from agencia where RFC= ?";
	private static final String SQL_UPDATE = ""+
	"update agencia set nombre=?, razon_social=?, RFC=?, cuenta=?, clabe=?, contacto_direccion=?, contacto_telefono=?, contacto_sitioweb =? where RFC=?";
	
	public void update(AgenciaDTO dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombre());
            ps.setString(2, dto.getRazonSocial());
            ps.setString(3, dto.getRFC());
            ps.setString(4, dto.getCuenta());
            ps.setString(5, dto.getClabe());
            ps.setString(6, dto.getContacto_direccion());
            ps.setString(7, dto.getContacto_telefono());
            ps.setString(8, dto.getContacto_sitioweb()); 
            ps.setString(9, dto.getRFC());
            ps.executeUpdate();
        } finally {
            //cerrar(ps);
            //cerrar(conn);
        }
    }
	
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
	
	
	public AgenciaDTO select(AgenciaDTO dto, Connection conn) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setString(1, dto.getRFC());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0) {
                return (AgenciaDTO) results.get(0);
            } else {
                return null;
            }
        } finally {
           // cerrar(rs);
            
            
        }
        
    }
	
	
	
	private List getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList();
        while (rs.next()) {
           AgenciaDTO dto = new AgenciaDTO();
           dto.setNombre(rs.getString("nombre"));
           dto.setRazonSocial(rs.getString("razon_social"));
           dto.setRFC(rs.getString("RFC"));
           dto.setCuenta(rs.getString("cuenta"));
           dto.setClabe(rs.getString("clabe"));
           dto.setContacto_direccion(rs.getString("contacto_direccion"));
           dto.setContacto_telefono(rs.getString("contacto_telefono"));
           dto.setContacto_sitioweb(rs.getString("contacto_sitioweb"));
            results.add(dto);
        }
        return results;
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
