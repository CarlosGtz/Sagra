/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dto.UsuarioDTO;

/**
 *
 * @author carlos
 */
public class UsuarioDAO {

    private static final String SQL_SELECT
            = "SELECT nombre, apellidos, user_password"
            + "  FROM usuario where user_name= ?";
    private static final String SQL_INSERT ="insert into usuario ("
    +"nombre, apellidos,user_name,user_password,e_mail,RFC,CURP,tarjeta_no,contacto_telefono) values (?,?,?,?,?,?,?,?,?)";

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
            ps.setString(6, "RFC");
            ps.setString(7, "CURP");
            ps.setString(8, "tarjeta");
            ps.setString(9, "contacto");
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
            dto.setNombre(rs.getString("nombre"));
            dto.setApellidos(rs.getString("apellidos"));
            dto.setPass(rs.getString("user_password"));
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


