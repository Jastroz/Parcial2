package modelo;

public class Producto 
{
	private int CodigoProducto;
	private String NombreProducto;
	private double ValorProducto;

	public Producto()	
	{
		this.CodigoProducto = 0;
		this.NombreProducto = "";
		this.ValorProducto = 0;		
	}

	public int getCodigoProducto() 
	{
		return CodigoProducto;
	}
	public void setCodigoProducto(int codigoProducto)
	{
		CodigoProducto = codigoProducto;
	}
	public String getNombreProducto()
	{
		return NombreProducto;
	}
	public void setNombreProducto(String nombreProducto) 
	{
		NombreProducto = nombreProducto;
	}
	public double getValorProducto() 
	{
		return ValorProducto;
	}
	public void setValorProducto(double valorProducto) 
	{
		this.ValorProducto = valorProducto;
	}













}
