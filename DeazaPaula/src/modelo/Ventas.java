package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ventas {

	private DetalleVentas[] detalleVentas;
	private Producto[] productos;
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
		productos = new Producto[maxregistros];
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
		f = new File(nombrearchivo);
		String[] dv = new String[3];
		int i=0;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea != null)
			{
				dv = linea.split(",");
				productos[i] = new Producto();
				this.productos[i].setCodigoProducto(Integer.parseInt(dv[0])); 
				this.productos[i].setNombreProducto(dv[1]);
				this.productos[i].setValorProducto(Double.parseDouble(dv[2]));
				linea = br.readLine();
				i++;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		this.totalRegPR =i;
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
	
		for (int i = 0; i < this.totalRegDV ; i++) {
			valorTotal += detalleVentas[i].getValorTotal();
		}
		valorIVA = valorTotal*(IVA/100);
		valormasIVA = valorTotal + valorIVA;
		}
	public String generarReporteVentas() {
		
		String reporte = "";
		reporte = "Consolidado de ventas por dia \n \n";
	
			reporte += "**Total ventas " + getValorTotal()+"\n";
			reporte += "**Valor de IVA " + getValorIVA() + "\n";
			reporte += "**Total con IVA " + getValormasIVA();
		return reporte;
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
	public DetalleVentas[] getDetalleVentas() {
		return detalleVentas;
	}
	public void setDetalleVentas(DetalleVentas[] detalleVentas) {
		this.detalleVentas = detalleVentas;
	}
	public Producto[] getProductos() {
		return productos;
	}
	public void setProductos(Producto[] productos) {
		this.productos = productos;
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
	public int getTotalRegDV() {
		return totalRegDV;
	}
	public void setTotalRegDV(int totalRegDV) {
		this.totalRegDV = totalRegDV;
	}
	public int getTotalRegPR() {
		return totalRegPR;
	}
	public void setTotalRegPR(int totalRegPR) {
		this.totalRegPR = totalRegPR;
	}
	public File getF() {
		return f;
	}
	public void setF(File f) {
		this.f = f;
	}
	public FileReader getFr() {
		return fr;
	}
	public void setFr(FileReader fr) {
		this.fr = fr;
	}
	public BufferedReader getBr() {
		return br;
	}
	public void setBr(BufferedReader br) {
		this.br = br;
	}
}

