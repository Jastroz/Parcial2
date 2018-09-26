package controlador;

import java.io.IOException;

import modelo.Mundo;
import vista.Interfaz;

public class Controlador 
{

	private Mundo m;	
	private Interfaz i;
	
	public Controlador() throws IOException
	{
		m = new Mundo();
		i = new Interfaz();
		
		m.getConfig().getPropiedades();
		
		m.getVentas().leerArchivoProductos(m.getConfig().getArchivoProducto());
		
		m.getVentas().leerArchivoDetalleVentas(m.getConfig().getArchivoDetalleVenta());
		
		m.getVentas().consolidarVentas(m.getConfig().getIVA());
		
		i.escribirResultados(m.getVentas().generarReporteVentas());
		
		i.escribirResultados(m.getVentas().generarReporteXProducto());

		
	}

}
