package modelo.dto;

public class AutoDTO {
	private String modelo;
	private String placas;
	private String color;
	private String marca;
	private String año;
	private String numeroPasajeros;
	private String tipo;
	
	
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
	@Override
	public String toString() {
		return "AutoDTO [modelo=" + modelo + ", placas=" + placas + ", color=" + color + ", marca=" + marca + ", año="
				+ año + ", numeroPasajeros=" + numeroPasajeros + ", tipo=" + tipo + "]";
	}
	

}
