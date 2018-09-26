package modelo;

public class DetalleVentas 
{
	private int codigoDetalleVenta;
	private int codigoProducto;
	private int cantidad;
	private int valorUnitario;
	private int valorTotal;
	
	public DetalleVentas()
	{
		
	}
	public int getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}
	public void setCodigoDetalleVenta(int codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(int valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public int getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}
}
