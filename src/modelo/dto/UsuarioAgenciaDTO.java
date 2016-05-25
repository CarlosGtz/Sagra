package modelo.dto;

public class UsuarioAgenciaDTO {
	private String nombre;
	private String usuario;
	private String pass;
	private String RFCagencia;
	private String apellidos;
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
	
	public String getRFCagencia() {
		return RFCagencia;
	}
	public void setRFCagencia(String rFCagencia) {
		RFCagencia = rFCagencia;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	@Override
	public String toString() {
		return "UsuarioAgenciaDTO [nombre=" + nombre + ", usuario=" + usuario + ", pass=" + pass + ", RFCagencia="
				+ RFCagencia + ", apellidos=" + apellidos + "]";
	}
	
	


	
	

}
