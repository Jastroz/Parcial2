package modelo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Configuracion {
	private String archivoVenta;
	private String archivoDetalleVenta;
	private String archivoProducto;
	private double IVA;
	private int maxRegistros;
	private Properties prop;
	private String archivoprop = "configuracion.properties";

	public Configuracion() {
		prop = new Properties();
		archivoVenta = "";
		archivoDetalleVenta = "";
		archivoProducto = "";
		maxRegistros = 0;
		IVA = 0;
		getPropiedades();
	}

	public void getPropiedades() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(archivoprop);
			prop.load(input);
			
			archivoVenta = prop.getProperty("archivoVenta");
			archivoDetalleVenta = prop.getProperty("archivoDetalleVenta");
			archivoProducto = prop.getProperty("archivoProducto");
			maxRegistros = Integer.parseInt(prop.getProperty("maxRegistros"));
			IVA = Integer.parseInt(prop.getProperty("iva"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getArchivoDetalleVenta() {
		return archivoDetalleVenta;
	}

	public String getArchivoProducto() {
		return archivoProducto;
	}

	public double getIVA() {
		return IVA;
	}

	public int getMaxRegistros() {
		return maxRegistros;
	}
}
