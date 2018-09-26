package Modelo;

import java.io.File;
import java.io.FileInputStream;
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

	public void setArchivoVenta(String archivoVenta) {
		this.archivoVenta = archivoVenta;
	}

	public String getArchivoDetalleVenta() {
		return archivoDetalleVenta;
	}

	public void setArchivoDetalleVenta(String archivoDetalleVenta) {
		this.archivoDetalleVenta = archivoDetalleVenta;
	}

	public String getArchivoProducto() {
		return archivoProducto;
	}

	public void setArchivoProducto(String archivoProducto) {
		this.archivoProducto = archivoProducto;
	}

	public double getIVA() {
		return IVA;
	}

	public void setIVA(double iVA) {
		IVA = iVA;
	}

	public int getMaxRegistros() {
		return maxRegistros;
	}

	public void setMaxRegistros(int maxRegistros) {
		this.maxRegistros = maxRegistros;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getArchivoprop() {
		return archivoprop;
	}

	public void setArchivoprop(String archivoprop) {
		this.archivoprop = archivoprop;
	}
	
	
	
}
