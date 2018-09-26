package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuracion 
{
	private String archivoVenta;
	private String archivoDetalleVenta;
	private String archivoProducto;
	private double IVA;
	private int maxRegistros;
	private Properties prop;
	private String archivoprop = "configuracion.properties";
	
	public Configuracion()
	{
		prop = new Properties();
		archivoVenta="";
		archivoDetalleVenta="";
		archivoProducto="";
		maxRegistros=0;
		IVA = 0;
		getPropiedades();
	}
	
	public int getMaxRegistros() {
		return maxRegistros;
	}

	public void setMaxRegistros(int maxRegistros) {
		this.maxRegistros = maxRegistros;
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

	public void setIVA(double string) {
		IVA = string;
	}
	
	public void getPropiedades()
	{
		try
		{
			prop.load(new FileInputStream(archivoprop));
			this.setArchivoVenta(prop.getProperty("archivoVenta"));
			this.setArchivoDetalleVenta(prop.getProperty("archivoDetalleVenta"));
			this.setArchivoProducto(prop.getProperty("archivoProducto"));
			this.setIVA(Double.parseDouble(prop.getProperty("iva"))/100);
			this.setMaxRegistros(Integer.parseInt(prop.getProperty("maxRegistros")));	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
