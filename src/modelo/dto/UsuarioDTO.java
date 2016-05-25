/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.util.Date;

/**
 *
 * @author carlos
 */
public class UsuarioDTO {
    private String nombre;
    private String apellidos;
    private String usuario;
    private String pass;
    private String email;
    private Date fecha_nacimiento;
    private String RFC;
    private String CURP;
    private String tarjeta_no;
    private String tarjeta_fechalim;
    private String tarjeta_codigo;
    private String cred_elector;
    private String contacto_telefono;
    
    
    public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getRFC() {
		return RFC;
	}

	public void setRFC(String rFC) {
		RFC = rFC;
	}

	public String getCURP() {
		return CURP;
	}

	public void setCURP(String cURP) {
		CURP = cURP;
	}

	public String getTarjeta_no() {
		return tarjeta_no;
	}

	public void setTarjeta_no(String tarjeta_no) {
		this.tarjeta_no = tarjeta_no;
	}

	public String getTarjeta_fechalim() {
		return tarjeta_fechalim;
	}

	public void setTarjeta_fechalim(String tarjeta_fechalim) {
		this.tarjeta_fechalim = tarjeta_fechalim;
	}

	public String getTarjeta_codigo() {
		return tarjeta_codigo;
	}

	public void setTarjeta_codigo(String tarjeta_codigo) {
		this.tarjeta_codigo = tarjeta_codigo;
	}

	public String getCred_elector() {
		return cred_elector;
	}

	public void setCred_elector(String cred_elector) {
		this.cred_elector = cred_elector;
	}

	public String getContacto_telefono() {
		return contacto_telefono;
	}

	public void setContacto_telefono(String contacto_telefono) {
		this.contacto_telefono = contacto_telefono;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }



    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

	@Override
	public String toString() {
		return "UsuarioDTO [nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario + ", pass=" + pass
				+ ", email=" + email + ", fecha_nacimiento=" + fecha_nacimiento + ", RFC=" + RFC + ", CURP=" + CURP
				+ ", tarjeta_no=" + tarjeta_no + ", tarjeta_fechalim=" + tarjeta_fechalim + ", tarjeta_codigo="
				+ tarjeta_codigo + ", cred_elector=" + cred_elector + ", contacto_telefono=" + contacto_telefono + "]";
	}

    
}
