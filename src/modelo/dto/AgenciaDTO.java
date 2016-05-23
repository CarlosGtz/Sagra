package modelo.dto;

public class AgenciaDTO {
	private String nombre;
	private String usuario;
	private String email;
	private String pass;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "AgenciaDTO [nombre=" + nombre + ", usuario=" + usuario + ", email=" + email + ", pass=" + pass + "]";
	}
	

}
