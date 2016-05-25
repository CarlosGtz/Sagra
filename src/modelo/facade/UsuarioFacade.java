/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author carlos
 */
public class UsuarioFacade {
    private Connection cnn;
    private UsuarioDAO dao;
    
    
    public UsuarioFacade(Connection cnn) {
        this.cnn = cnn;
        dao = new UsuarioDAO();
    }
    public int crear(UsuarioDTO dto) throws SQLException {
        return dao.create(dto, cnn);
    }
    //public List listar() throws SQLException {
    //    return dao.loadAll(cnn);
    //}
    public UsuarioDTO leer(UsuarioDTO dto)throws SQLException {
        return dao.select(dto, cnn);
    }
    public void actualizar(UsuarioDTO dto)throws SQLException {
        dao.update(dto, cnn);
    }
    //public void elimina(UsuarioDTO dto)throws SQLException {
    //     dao.delete(dto, cnn);
    //}
}
