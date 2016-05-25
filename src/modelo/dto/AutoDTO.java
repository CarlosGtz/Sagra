package modelo.dto;

public class AutoDTO {
	private String RFCAgencia;
	private String modelo;
	private String placas;
	private String color;
	private String marca;
	private String año;
	private String numeroPasajeros;
	private String tipo;
	private boolean disponible;
	private String fecha_regreso;//opc
	private String costo;
	
	

	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public String getRFCAgencia() {
		return RFCAgencia;
	}
	public void setRFCAgencia(String rFCAgencia) {
		RFCAgencia = rFCAgencia;
	}
	public String getFecha_regreso() {
		return fecha_regreso;
	}
	public void setFecha_regreso(String fecha_regreso) {
		this.fecha_regreso = fecha_regreso;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	public String getNumeroPasajeros() {
		return numeroPasajeros;
	}
	public void setNumeroPasajeros(String numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getfecha_regreso() {
		return fecha_regreso;
	}
	public void setfecha_regreso(String fecha_regreso) {
		this.fecha_regreso = fecha_regreso;
	}
	@Override
	public String toString() {
		return "AutoDTO [modelo=" + modelo + ", placas=" + placas + ", color=" + color + ", marca=" + marca + ", año="
				+ año + ", numeroPasajeros=" + numeroPasajeros + ", tipo=" + tipo + ", disponible=" + disponible
				+ ", fecha_regreso=" + fecha_regreso + "]";
	}


}
