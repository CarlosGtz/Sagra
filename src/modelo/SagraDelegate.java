/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import modelo.dto.UsuarioAgenciaDTO;
import modelo.dao.UsuarioAgenciaDAO;
import modelo.dto.AgenciaDTO;
import modelo.dto.AutoDTO;
import modelo.dto.UsuarioDTO;
import modelo.facade.UsuarioAgenciaFacade;
import modelo.facade.AgenciaFacade;
import modelo.facade.AutoFacade;
import modelo.facade.UsuarioFacade;

/**
 *
 * @author carlos
 */
public class SagraDelegate {
	private Connection cnn;
	private UsuarioFacade artFacade;
	private UsuarioAgenciaFacade usrAgeFacade;
	private AgenciaFacade ageFacade;
	private AutoFacade autoFacade;

	public SagraDelegate() {
		String user = "be44bc54f310a4";
		String pwd = "1e3b090d";
		String url = "jdbc:mysql://23.102.165.199:3306/sagra";
		String mySqlDriver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(mySqlDriver);
			cnn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		artFacade = new UsuarioFacade(cnn);
		usrAgeFacade = new UsuarioAgenciaFacade(cnn);
		autoFacade = new AutoFacade(cnn);
		ageFacade = new AgenciaFacade(cnn);
	}

	public UsuarioDTO leerUsuario(UsuarioDTO dto) throws SQLException {
		return artFacade.leer(dto);
	}

	public int crearArticulo(UsuarioDTO dto) throws SQLException {
		return artFacade.crear(dto);

	}

	public int crearUsuarioAgencia(UsuarioAgenciaDTO dto) throws SQLException {
		return usrAgeFacade.crear(dto);
	}

	public int crearAuto(AutoDTO dto) throws SQLException {
		return autoFacade.crear(dto);
	}

	public List listarAutos() throws SQLException {
		return autoFacade.listar();
	}
	
	public List listarAutosxAgencia(AutoDTO dto) throws SQLException {
		return autoFacade.listarXAgencia(dto);
	}
	

	public void crearAgencia(UsuarioAgenciaDTO dto, AgenciaDTO aDto) throws SQLException{	
		ageFacade.crear(aDto);
		crearUsuarioAgencia(dto);
	}
	
	public UsuarioAgenciaDTO leerUsuarioAgencia(UsuarioAgenciaDTO dto)throws SQLException{
		return usrAgeFacade.leer(dto);
	}
	
	public AgenciaDTO leerAgecia(AgenciaDTO dto)throws SQLException{
		return ageFacade.leer(dto);
	}
	
	public AutoDTO leerAuto(AutoDTO dto)throws SQLException{
		return autoFacade.leer(dto);
	}
	public void actualizarAgencia(AgenciaDTO dto,UsuarioAgenciaDTO aDto) throws SQLException{
		ageFacade.actualizar(dto);
		actualizarUsuarioAgencia(aDto);
	}
	
	public void actualizarUsuarioAgencia(UsuarioAgenciaDTO dto)throws SQLException{
		usrAgeFacade.actualizar(dto);
	}
	
	public void actualizarUsuario(UsuarioDTO dto) throws SQLException{
		artFacade.actualizar(dto);
	}
	public void actualizarAuto(AutoDTO dto)throws SQLException{
		autoFacade.actualizar(dto);
	}
	public void eliminarAuto(AutoDTO dto)throws SQLException{
		autoFacade.eliminar(dto);
	}
}
