package controlador;

import modelo.Mundo;
import vista.Interfaz;

public class Control {
	private Mundo mundo;
	private Interfaz vista;
	
	
	public Control() {
		mundo = new Mundo();
		vista = new Interfaz();
		
		mundo.getConfig().getPropiedades();
		mundo.getVentas().leerArchivoProducto(mundo.getConfig().getArchivoProducto());
		mundo.getVentas().leerArchivoDetalleVentas(mundo.getConfig().getArchivoDetalleVenta());
		mundo.getVentas().consolidarVentas(mundo.getConfig().getIVA());
		vista.escribirResultados(mundo.getVentas().generarReporteVentas());
		vista.escribirResultados(mundo.getVentas().generarReporteXProducto());
			

		

	}

}
