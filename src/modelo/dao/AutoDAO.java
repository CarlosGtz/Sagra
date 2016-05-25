package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dto.UsuarioAgenciaDTO;
import modelo.dto.AutoDTO;

public class AutoDAO {
	private static final String SQL_INSERT =""+
			"insert into autos (RFCAgencia,placas,modelo,color,marca,anio,no_pasajeros,tipo_auto,disponible)"+
			"values (?,?,?,?,?,?,?,?,?)";
	private static final String SQL_SELECT_ALL = "select marca,placas,color,modelo,tipo_auto,anio,no_pasajeros from autos ORDER BY RFCAgencia";
	
	public int create(AutoDTO dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            //ps.setInt(1, dto.getIDagencia());se obtendra el id de la sesion de la agencia
            ps.setString(1, dto.getRFCAgencia());
            ps.setString(2, dto.getPlacas());
            ps.setString(3, dto.getModelo());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getMarca());
            ps.setString(6, dto.getAño());
            ps.setString(7, dto.getNumeroPasajeros());
            ps.setString(8, dto.getTipo());
            ps.setString(9, "1");
            return ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(conn);
        }
    }
	

    public List selectAll(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0) {
                return results;
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
            AutoDTO dto = new AutoDTO();
            dto.setMarca(rs.getString("marca"));
            dto.setPlacas(rs.getString("placas"));
            dto.setColor(rs.getString("color"));
            dto.setModelo(rs.getString("modelo"));
            dto.setTipo(rs.getString("tipo_auto"));
            dto.setAño(rs.getString("anio"));
            dto.setNumeroPasajeros(rs.getString("no_pasajeros"));            
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
