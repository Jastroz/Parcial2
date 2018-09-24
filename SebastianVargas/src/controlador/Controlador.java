package controlador;

import modelo.Mundo;
import vista.Interfaz;

public class Controlador {

	private Mundo bd;
	
	private Interfaz gui;
	
	public Controlador() 
	{

		//aqui van los constructores tanto de Mundo, como de Vista
		
		bd = new Mundo();
		gui = new Interfaz();

		//aquí van los métodos que ejecutarán el programa

		bd.getConfig().getPropiedades();
		bd.getVentas().leerArchivoProductos(bd.getConfig().getArchivoProducto());
		bd.getVentas().leerArchivoDetalleVentas(bd.getConfig().getArchivoDetalleVenta());
		bd.getVentas().consolidarVentas(bd.getConfig().getIVA());
		gui.escribirResultados(bd.getVentas().generarReporteVentas());
		gui.escribirResultados(bd.getVentas().generarReporteXProducto());
	}

}