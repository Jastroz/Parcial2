package Controlador;


import modelo.Mundo;
import Vista.Interfaz;

public class Controlador {

	private Mundo bd;
	
	private Interfaz gui;
	
	public Controlador() {

		//aqui van los constructores tanto de Mundo, como de Vista
		
		bd = new Mundo();
		gui = new Interfaz();

		bd.getConfig().getProp();
		bd.getVentas().leerArchivoProductos(bd.getConfig().getArchivoProducto());
		bd.getVentas().leerArchivoDetalleVentas(bd.getConfig().getArchivoDetalleVenta());
		bd.getVentas().consolidarVentas(bd.getConfig().getIVA());
		gui.escribirResultados(bd.getVentas().generarReporteVentas());
		gui.escribirResultados(bd.getVentas().generarReporteXProducto());
	
	}

}