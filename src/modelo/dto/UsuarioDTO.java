/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author carlos
 */
public class UsuarioDTO {
    private String nombre;
    private String apellidos;
    private String usuario;
    private String email;
    private String pass;
    
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
    
    public String toString(){
        return "Nombre: "+nombre+
                "\nUsurio:"+usuario+
                "\nemail:"+email+
                 "\npass:"+pass;
        
    }
    
}
