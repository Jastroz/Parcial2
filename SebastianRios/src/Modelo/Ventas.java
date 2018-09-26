package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ventas 
{

	
	private DetalleVentas[] detalleVentas;
	private Productos[] productos;
	private double valorTotal;
	private double valorIVA;
	private double valormasIVA;
	private int totalRegDV;
	private int totalRegPR;
	private File f;
	private FileReader fr;
	private BufferedReader br;

	public Ventas(int maxregistros) {
		detalleVentas = new DetalleVentas[maxregistros];
		productos = new Productos[maxregistros];
		this.valorTotal = 0;
		this.valorIVA = 0;
		this.valormasIVA = 0;
	}
	
	public void leerArchivoDetalleVentas(String nombreArchivo) 
	{
		f = new File(nombreArchivo);
		String[] dv = new String[5];
		int i=0;
		try 
		{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea = br.readLine();

			while(linea != null) {
				dv = linea.split(",");
				detalleVentas[i] = new DetalleVentas();
				this.detalleVentas[i].setCodigoDetalleVenta(Integer.parseInt(dv[0]));
				this.detalleVentas[i].setCodigoProducto(Integer.parseInt(dv[1]));
				this.detalleVentas[i].setCantidad(Integer.parseInt(dv[2]));
				this.detalleVentas[i].setValorUnitario(Double.parseDouble(dv[3]));
				this.detalleVentas[i].setValorTotal(Double.parseDouble(dv[4]));
				linea = br.readLine();
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.totalRegDV = i;
	}
	
	public void leerArchivoProductos(String nombrearchivo)
	{
		
		try
		{
			f = new File(nombrearchivo);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			int i = 0;
			
			String linea = br.readLine();
			while(linea != null)
			{
				String[] datos = linea.split(",");
				productos[i] = new Productos();
				productos[i].setCodigoProducto(Integer.parseInt(datos[0]));
				productos[i].setNombreProducto(datos[1]);
				productos[i].setValorProducto(Double.parseDouble(datos[2]));
				
				linea = br.readLine();
				i++;
			}
			 
			this.totalRegPR = i;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	public String buscarProducto(int codproducto) 
	{
		int i;
		String valor = null;
		for (i = 0; i<this.totalRegPR ; i++) {
			if (productos[i].getCodigoProducto() == codproducto) {
				valor = productos[i].getNombreProducto();
			}
		}
		return valor;
	}
	
	public void consolidarVentas(double IVA) 
	{
		for (int i = 0; i < this.totalRegDV; i++) 
		{
			this.valorTotal+=  this.detalleVentas[i].getValorTotal();
			this.valorIVA+= this.detalleVentas[i].getValorTotal() * IVA / 100;
		}
		this.valormasIVA = this.valorTotal + this.valorIVA;
		
	}
	
	public String generarReporteVentas() 
	{
		String reporteVentas = "";
		
		reporteVentas+= "Consolidado de Ventas del Dia\n\n";
		reporteVentas+= "** Total Ventas : " + valorTotal + "\n";
		reporteVentas+= "** Valor de IVA : " + valorIVA + "\n";
		reporteVentas+= "** Total con IVA : " + valormasIVA;
		
		return reporteVentas;
	}
	
	public String generarReporteXProducto() {
		String linea = "";
		linea = "Listado de Ventas por Producto\n\n";
		for (int i=0 ; i< this.totalRegDV ; i++) {
			linea += this.buscarProducto(this.detalleVentas[i].getCodigoProducto())+" -- ";
			linea += this.detalleVentas[i].getValorUnitario()+" -- ";
			linea += this.detalleVentas[i].getCantidad()+" -- ";
			linea += this.detalleVentas[i].getValorTotal()+"\n";
		}
		return linea;
	}
}
