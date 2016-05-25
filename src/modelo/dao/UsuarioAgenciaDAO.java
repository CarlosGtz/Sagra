package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dto.UsuarioAgenciaDTO;
import modelo.dto.UsuarioDTO;

public class UsuarioAgenciaDAO {
	private static final String SQL_INSERT ="insert into agencia_usuario (RFCagencia,user_name,user_password,nombre,apellidos)"+
			"values (?,?,?,?,?)";
	 private static final String SQL_SELECT = "SELECT *"
		     + "  FROM agencia_usuario where user_name= ?";
	
	public int create(UsuarioAgenciaDTO dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getRFCagencia());
            ps.setString(2, dto.getUsuario());
            ps.setString(3, dto.getPass());
            ps.setString(4, dto.getNombre());
            ps.setString(5, dto.getApellidos());          
            return ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(conn);
        }
    }
	
	public UsuarioAgenciaDTO select(UsuarioAgenciaDTO dto, Connection conn) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setString(1, dto.getUsuario());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0) {
                return (UsuarioAgenciaDTO) results.get(0);
            } else {
                return null;
            }
        } finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(conn);
        }
        
    }
	
	
	private List getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList();
        while (rs.next()) {
            UsuarioAgenciaDTO dto = new UsuarioAgenciaDTO();
            dto.setNombre(""+rs.getString("nombre"));
            dto.setApellidos(""+rs.getString("apellidos"));
            dto.setPass(""+rs.getString("user_password"));
            dto.setUsuario(""+rs.getString("user_name"));
            dto.setRFCagencia(""+rs.getString("RFCagencia"));
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
