package controlador;

import modelo.Mundo;
import vista.Interfaz;

public class Controlador {

	private Mundo bd;

	private Interfaz gui;

	public Controlador() {

		bd = new Mundo();
		gui = new Interfaz();


		bd.getConfig().getPropiedades();
		bd.getVentas().leerArchivoProductos(bd.getConfig().getArchivoProducto());
		bd.getVentas().leerArchivoDetalleVentas(bd.getConfig().getArchivoDetalleVenta());
		bd.getVentas().consolidarVentas(bd.getConfig().getIVA());
		gui.escribirResultados(bd.getVentas().generarReporteVentas());
		gui.escribirResultados(bd.getVentas().generarReporteXProducto());

	}
}
