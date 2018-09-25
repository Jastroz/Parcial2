package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class Ventas {
	
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
		f = new File("detalleventa.txt");
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
		int v = 0;
	 String[] spl = new String[5];
		try {
			fr = new FileReader("producto.txt");
			br = new BufferedReader(fr);
			String linea = br.readLine();

			while(linea != null)
			{
				spl = linea.split(",");
				
				productos[v] = new Productos();

				this.productos[v].setCodigoProducto(Integer.parseInt(spl[0]));
				this.productos[v].setNombreProducto(((spl[1])));
				this.productos[v].setValorProducto(Integer.parseInt(spl[2]));
				
				linea = br.readLine();
				v++;
			}
			this.totalRegPR ++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String buscarProducto(int codproducto) {
		int i;
		String valor = null;
		for (i = 0; i<this.totalRegPR ; i++) {
			if (productos[i].getCodigoProducto() == codproducto) {
				valor = productos[i].getNombreProducto();
			}
		}
		return valor;
	}
	
	public void consolidarVentas(double IVA) {
		
		double sumatoria = 0;
	

		for (int i = 0; i < totalRegDV; i++) {
		int cantidad = detalleVentas[i].getCantidad();
		double precio = this.detalleVentas[i].getValorUnitario();
		
		sumatoria += precio* cantidad;			
		}
		
		
	}
	
	
	public String generarReporteVentas() {
		//método a construir
		
		String reporte = "";
		reporte = "Consolidado de ventas del dia";
		int totalV = 0;
		int iva = 0;
		int ivamas = 0;
		
		for (int i = 0; i < this.totalRegDV; i++) {
			
			totalV += (int) this.detalleVentas[i].getValorTotal();
			
			iva = (int) ((totalV* 19 ) /100);
			ivamas = totalV + iva;

			
		}
		reporte += " \n"+ " ** "+ " El valor total es: " + totalV + " \n";
		reporte += " ** " + "El iva es:  " + iva + "\n";
		reporte += " ** " + " El valor mas iva es: " +ivamas;
	
		
		
		return reporte;
	}
	
	public String generarReporteXProducto() {
		String linea = "";
		linea = "Listado de Ventas por Producto\n\n";
		for (int i=0 ; i< this.totalRegDV ; i++) {

			linea += this.productos[i].getNombreProducto() + " -- ";
			linea += this.productos[i].getValorProducto()+" -- ";
			linea += this.detalleVentas[i].getCantidad()+" -- ";
			linea += this.detalleVentas[i].getValorTotal()+"\n";
		}
		return linea;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getValorIVA() {
		return valorIVA;
	}

	public void setValorIVA(double valorIVA) {
		this.valorIVA = valorIVA;
	}

	public double getValormasIVA() {
		return valormasIVA;
	}

	public void setValormasIVA(double valormasIVA) {
		this.valormasIVA = valormasIVA;
	}
	
}
