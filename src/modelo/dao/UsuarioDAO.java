/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dto.UsuarioAgenciaDTO;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author carlos
 */
public class UsuarioDAO {

    private static final String SQL_SELECT
            = "SELECT *"
            + "  FROM usuario where user_name= ?";
    private static final String SQL_INSERT ="insert into usuario ("
    +"nombre, apellidos,user_name,user_password,e_mail,fecha_nacimiento,RFC,CURP,tarjeta_no,tarjeta_fechalim,tarjeta_codigo,cred_elector,contacto_telefono)"+
    		" values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = ""+
			"update usuario set nombre=?, apellidos=?, user_name=?, user_password=?, e_mail=?,fecha_nacimiento=?, RFC=?,CURP=?,tarjeta_no=?,tarjeta_fechalim=?, tarjeta_codigo=?,cred_elector=?,contacto_telefono=? where IDusuario=?";

    
    public void update(UsuarioDTO dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            
            ps.setString(1, dto.getNombre());
            ps.setString(2, dto.getApellidos());
            ps.setString(3, dto.getUsuario());
            ps.setString(4, dto.getPass());
            ps.setString(5, dto.getEmail());
            ps.setDate(6, new java.sql.Date(dto.getFecha_nacimiento().getTime()));
            ps.setString(7, dto.getRFC());
            ps.setString(8, dto.getCURP());
            ps.setString(9, dto.getTarjeta_no());
            ps.setString(10, dto.getTarjeta_fechalim());
            ps.setString(11, dto.getTarjeta_codigo());
            ps.setString(12, dto.getCred_elector());
            ps.setString(13, dto.getContacto_telefono());
            ps.setString(14, dto.getIdUser());
            ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(conn);
        }
    }
    public UsuarioDTO select(UsuarioDTO dto, Connection conn) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setString(1, dto.getUsuario());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0) {
                return (UsuarioDTO) results.get(0);
            } else {
                return null;
            }
        } finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(conn);
        }
        
    }
    
    public int create(UsuarioDTO dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getNombre());
            ps.setString(2, dto.getApellidos());
            ps.setString(3, dto.getUsuario());
            ps.setString(4, dto.getPass());
            ps.setString(5, dto.getEmail());
            ps.setDate(6, new java.sql.Date(dto.getFecha_nacimiento().getTime()));
            ps.setString(7, dto.getRFC());
            ps.setString(8, dto.getCURP());
            ps.setString(9, dto.getTarjeta_no());
            ps.setString(10, dto.getTarjeta_fechalim());
            ps.setString(11, dto.getTarjeta_codigo());
            ps.setString(12, dto.getCred_elector());
            ps.setString(13, dto.getContacto_telefono());
           return ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(conn);
        }
    }
    
    private List getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList();
        while (rs.next()) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setIdUser(rs.getString("IDusuario"));
            dto.setNombre(rs.getString("nombre"));
            dto.setApellidos(rs.getString("apellidos"));
            dto.setUsuario(rs.getString("user_name"));
            dto.setPass(rs.getString("user_password"));
            dto.setEmail(rs.getString("e_mail"));
            dto.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
            dto.setRFC(rs.getString("RFC"));
            dto.setCURP(rs.getString("CURP"));
            dto.setTarjeta_no(rs.getString("tarjeta_no"));
            dto.setTarjeta_fechalim(rs.getString("tarjeta_fechalim"));
            dto.setTarjeta_codigo(rs.getString("tarjeta_codigo"));
            dto.setCred_elector(rs.getString("cred_elector"));
            dto.setContacto_telefono(rs.getString("contacto_telefono"));
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


