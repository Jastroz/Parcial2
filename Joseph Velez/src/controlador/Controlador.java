package controlador;

import modelo.Mundo;
import vista.Interfaz;

public class Controlador 
{
	Mundo m;
	Interfaz gui;
	
	public Controlador()
	{
		m = new Mundo();
		gui = new Interfaz();
		
		
		m.getConfig().getPropiedades();
		m.getVentas().leerArchivoProductos(m.getConfig().getArchivoProducto());
		m.getVentas().leerArchivoDetalleVentas(m.getConfig().getArchivoDetalleVenta());
		m.getVentas().consolidarVentas(m.getConfig().getIVA());
		gui.escribirResultados(m.getVentas().generarReporteVentas());
		gui.escribirResultados2(m.getVentas().generarReporteXProducto());
	}
}