package modelo.dto;

public class AgenciaDTO {
	private String nombre;
	private String RazonSocial;
	private String usuario;
	private String email;
	private String pass;
	private String RFC;
	private String cuenta;
	private String clabe;
	private String contacto_direccion;
	private String contacto_telefono;
	private String contacto_sitioweb;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRazonSocial() {
		return RazonSocial;
	}
	public void setRazonSocial(String RazonSocial) {
		this.RazonSocial = RazonSocial;
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

	public String getRFC() {
		return RFC;
	}
	public void setRFC(String RFC) {
		this.RFC = RFC;
	}

	public String getcuenta() {
		return cuenta;
	}
	public void setcuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getclabe() {
		return clabe;
	}
	public void setclabe(String clabe) {
		this.clabe = clabe;
	}

	public String getcontacto_direccion() {
		return contacto_direccion;
	}
	public void setcontacto_direccion(String contacto_direccion) {
		this.contacto_direccion = contacto_direccion;
	}

	public String getcontacto_telefono() {
		return contacto_telefono;
	}
	public void setcontacto_telefono(String contacto_telefono) {
		this.contacto_telefono = contacto_telefono;
	}

	public String getcontacto_sitioweb() {
		return contacto_sitioweb;
	}
	public void setcontacto_sitioweb(String contacto_sitioweb) {
		this.contacto_sitioweb = contacto_sitioweb;
	}
	
	@Override
	public String toString() {
		return "AgenciaDTO [nombre=" + nombre + ", usuario=" + usuario + ", email=" + email + ", pass=" + pass + "]";
	}
	

}
