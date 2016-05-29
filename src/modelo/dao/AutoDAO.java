package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dto.UsuarioAgenciaDTO;
import modelo.dto.UsuarioDTO;
import modelo.dto.AutoDTO;

public class AutoDAO {
	private static final String SQL_INSERT =""+
			"insert into autos (RFCAgencia,placas,modelo,color,marca,anio,no_pasajeros,tipo_auto,disponible,costo_renta)"+
			"values (?,?,?,?,?,?,?,?,?,?)";
	
	private static final String SQL_SELECT_ALL = "select * from autos ORDER BY RFCAgencia";
	private static final String SQL_SELECT_ALL_AGENCIA = "select * from autos where RFCagencia = ?";
	private static final String SQL_SELECT = "select * from autos where placas = ?";
	private static final String SQL_UPDATE =""+
	"update autos set RFCagencia=?,placas=?,modelo=?,color=?,marca=?,anio=?,no_pasajeros=?,tipo_auto=?,costo_renta=? where IDauto =?";
	private static final String SQL_DELETE = "delete from autos where placas=?";
	
	public void delete(AutoDTO dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setString(1, dto.getPlacas());
            ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(conn);
        }
    }

	
	 public void update(AutoDTO dto, Connection conn) throws SQLException {
	        PreparedStatement ps = null;
	        try {
	            ps = conn.prepareStatement(SQL_UPDATE);
	            ps.setString(1, dto.getRFCAgencia());
	            ps.setString(2, dto.getPlacas());
	            ps.setString(3, dto.getModelo());
	            ps.setString(4, dto.getColor());
	            ps.setString(5, dto.getMarca());
	            ps.setString(6, dto.getAño());
	            ps.setString(7, dto.getNumeroPasajeros());
	            ps.setString(8, dto.getTipo());
	            ps.setString(9, dto.getCosto());
	            ps.setString(10, dto.getId());          
	            ps.executeUpdate();
	        } finally {
	            cerrar(ps);
	            cerrar(conn);
	        }
	    }
	
	
	 public AutoDTO select(AutoDTO dto, Connection conn) throws SQLException {

	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        try {
	            ps = conn.prepareStatement(SQL_SELECT);
	            ps.setString(1, dto.getPlacas());
	            rs = ps.executeQuery();
	            List results = getResults(rs);
	            if (results.size() > 0) {
	                return (AutoDTO) results.get(0);
	            } else {
	                return null;
	            }
	        } finally {
	            cerrar(rs);
	            cerrar(ps);
	            cerrar(conn);
	        }
	        
	    }
	
	
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
            ps.setString(10, dto.getCosto());
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
    
    public List selectAllxAgecnia(AutoDTO dto,Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT_ALL_AGENCIA);
            ps.setString(1, dto.getRFCAgencia());
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
            dto.setDisponible(rs.getBoolean("disponible"));
            dto.setfecha_regreso(rs.getString("fecha_regreso"));
            dto.setRFCAgencia(rs.getString("RFCagencia"));
            dto.setCosto(rs.getString("costo_renta"));
            dto.setId(rs.getString("IDauto"));
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
