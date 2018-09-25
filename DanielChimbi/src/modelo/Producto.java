package modelo;

public class Producto 
{
	private int CodigoProducto;
	private String NombreProducto;
	private int ValorProducto;
	
	public Producto()	
	{
		
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
	public void setValorProducto(int valorProducto) 
	{
		this.ValorProducto = valorProducto;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
