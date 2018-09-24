package modelo;

import java.io.File;
import java.io.FileReader;
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
		archivoVenta="";
		archivoDetalleVenta="";
		archivoProducto="";
		maxRegistros=0;
		IVA = 0;
		getPropiedades();
	}
	
	public void getPropiedades() 
	{
		try
		{
			File archivo = new File(archivoprop);
			FileReader fread = new FileReader(archivo);
			prop.load(fread);
			archivoDetalleVenta = prop.getProperty("archivoDetalleVenta");
			archivoVenta = prop.getProperty("archivoVenta");
			IVA = Double.parseDouble(prop.getProperty("iva"));
			archivoProducto = prop.getProperty("archivoProducto");
			maxRegistros = Integer.parseInt(prop.getProperty("maxRegistros"));
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}

	public String getArchivoVenta() {
		return archivoVenta;
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

	public Properties getProp() {
		return prop;
	}

	public String getArchivoprop() {
		return archivoprop;
	}
	

	
}