package Modelo;

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
		archivoVenta="venta.txt";
		archivoDetalleVenta="detalleventa.txt";
		archivoProducto="producto.txt";
		maxRegistros=20;
		IVA = 19;
		getPropiedades();
	}
	public void getPropiedades() {
	//método a construir
		prop.getProperty(archivoDetalleVenta);
		prop.getProperty(archivoprop);
		prop.getProperty(archivoVenta);
		prop.getProperty(archivoProducto);
		
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
	public void setIVA(double iVA) {
		IVA = iVA;
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

