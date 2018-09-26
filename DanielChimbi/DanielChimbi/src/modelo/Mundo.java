package modelo;

import java.io.IOException;

public class Mundo 
{
	private Ventas ventas;
	private Configuracion configuracion;

	public Mundo() throws IOException 
	{

		configuracion = new Configuracion();
		ventas = new Ventas(configuracion.getMaxRegistros());
	}

	public Ventas getVentas() 
	{
		return ventas;
	}

	public void setVentas(Ventas ventas) 
	{
		this.ventas = ventas;
	}

	public Configuracion getConfig()
	{
		return configuracion;
	}

	public void setConfig(Configuracion config) 
	{
		this.configuracion = config;
	}

}
