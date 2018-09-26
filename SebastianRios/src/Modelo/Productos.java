package Modelo;

public class Productos {

	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getValorProducto() {
		return valorProducto;
	}
	public void setValorProducto(double valorProducto) {
		this.valorProducto = valorProducto;
	}
	private int codigoProducto;
	private String nombreProducto;
	private double valorProducto;
	
}
