package modelo;

import modelo.Producto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Ventas 
{

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

	public Ventas(int maxregistros) 
	{
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
		} 

		catch (Exception e) 
		{
			e.printStackTrace();
		}
		this.totalRegDV = i;
	}

	public void leerArchivoProductos(String nombrearchivo)
	{
		// metodo a construir
		
		f = new File(nombrearchivo);

		String[] dv = new String[3];
		int i=0;
		try 
		{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea = br.readLine();

			while(linea != null) {
				dv = linea.split(",");
				productos[i] = new Producto();
				this.productos[i].setCodigoProducto(Integer.parseInt(dv[0]));
				this.productos[i].setNombreProducto(dv[1]);
				this.productos[i].setValorProducto(Double.parseDouble(dv[2]));

				linea = br.readLine();
				i++;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		totalRegPR = i;


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
		//método a construir
		this.valorIVA=0;
		this.valorTotal = 0;
		this.valormasIVA = 0;

		for (int i = 0; i < this.totalRegDV; i++) 
		{
			this.valorTotal += this.detalleVentas[i].getValorTotal();
		}
		this.valorIVA = this.valorTotal*(IVA/100);
		this.valormasIVA = this.valorTotal+this.valorIVA;
	}

	public String generarReporteVentas() 
	{
		//método a construir
		return "Consolidación sobre las ventas del día"+"\n"+"\n"+"**Total de Ventas: "+ getValorTotal()+"\n"+"**Valor del IVA: "+ getValorIVA()+"\n"+"**Total + Iva: "+ getValormasIVA();
	}

	public String generarReporteXProducto() {
		String linea = "";
		linea = "Listado de ventas por producto\n\n";
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

	public Producto[] getProducto() {
		return productos;
	}

	public void setPoductos(Producto[] productos) {
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