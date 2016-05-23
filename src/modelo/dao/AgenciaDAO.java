package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.dto.AgenciaDTO;
import modelo.dto.UsuarioDTO;

public class AgenciaDAO {
	private static final String SQL_INSERT ="insert into agencia_usuario (IDagencia,user_name,user_password,nombre,apellidos)"+
			"values (?,?,?,?,?)";
	public int create(AgenciaDTO dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, "1");
            ps.setString(2, dto.getUsuario());
            ps.setString(3, dto.getPass());
            ps.setString(4, dto.getNombre());
            ps.setString(5, dto.getEmail());          
            return ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(conn);
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
