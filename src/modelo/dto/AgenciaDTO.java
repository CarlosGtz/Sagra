package modelo.dto;

public class AgenciaDTO {
	private String nombre;
	private String RazonSocial;	
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
	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}
	public String getRFC() {
		return RFC;
	}
	public void setRFC(String rFC) {
		RFC = rFC;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getClabe() {
		return clabe;
	}
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}
	public String getContacto_direccion() {
		return contacto_direccion;
	}
	public void setContacto_direccion(String contacto_direccion) {
		this.contacto_direccion = contacto_direccion;
	}
	public String getContacto_telefono() {
		return contacto_telefono;
	}
	public void setContacto_telefono(String contacto_telefono) {
		this.contacto_telefono = contacto_telefono;
	}
	public String getContacto_sitioweb() {
		return contacto_sitioweb;
	}
	public void setContacto_sitioweb(String contacto_sitioweb) {
		this.contacto_sitioweb = contacto_sitioweb;
	}
	@Override
	public String toString() {
		return "AgenciaDTO [nombre=" + nombre + ", RazonSocial=" + RazonSocial + ", RFC=" + RFC + ", cuenta=" + cuenta
				+ ", clabe=" + clabe + ", contacto_direccion=" + contacto_direccion + ", contacto_telefono="
				+ contacto_telefono + ", contacto_sitioweb=" + contacto_sitioweb + "]";
	}

	

	
	
	

}
