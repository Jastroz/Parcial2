package modelo;

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

	public Ventas(int maxregistros)
	{
		detalleVentas = new DetalleVentas[maxregistros];
		productos = new Productos[maxregistros];
		this.valorTotal = 0;
		this.valorIVA = 0;
		this.valormasIVA = 0;
	}
	public void leerArchivoDetalleVentas(String nombreArchivo) 
	{
		f = new File(nombreArchivo);
		String[] dv = new String [5];
		int i=0;

		try 
		{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea = br.readLine();

			while(linea != null)
			{
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
		f = new File(nombrearchivo);
		String [] p = new String[3];
		int i=0;

		try
		{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			
			while (linea != null)
			{
				p = linea.split(",");
				productos[i] = new Productos();
				this.productos[i].setCodigoProducto(Integer.parseInt(p[0]));
				this.productos[i].setNombreProducto(p[1]);
				this.productos[i].setValorProducto(Integer.parseInt(p[2]));
				linea = br.readLine();
				i++;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		this.totalRegPR = i;
	}

	public String buscarProducto(int codproducto) 
	{
		int i;
		String valor = null;
		for (i = 0; i<this.totalRegPR ; i++)
		{
			if (productos[i].getCodigoProducto() == codproducto)
			{
				valor = productos[i].getNombreProducto();
			}
		}
		return valor;
	}

	public void consolidarVentas(double IVA)
	{
		double valorTotal = 0;
		double precioProducto = 0;
		int cantidad = 0;
		
		for (int i = 0; i < totalRegDV; i++)
		{
			cantidad = detalleVentas[i].getCantidad();
			precioProducto = detalleVentas[i].getValorUnitario();
			valorTotal += cantidad * precioProducto;
		}
		
		valorIVA = valorTotal * (IVA / 100);
		this.valorTotal = valorTotal;
		valorTotal = valorTotal + valorIVA;
		this.valormasIVA = valorTotal;
	}

	public String generarReporteVentas() 
	{
		String linea = "";
		linea = "Consolidado de ventas del dia";
		
		linea += "** Total Ventas: " + valorTotal;
		linea += "** Valor del IVA: " + valorIVA;
		linea += "** Total con IVA: " + valormasIVA;
		
		return linea;
	}

	public String generarReporteXProducto() 
	{
		String linea = "";
		linea = "Listado de Ventas por Producto\n\n";
		for (int i=0 ; i< this.totalRegDV ; i++) 
		{
			linea += this.buscarProducto(this.detalleVentas[i].getCodigoProducto())+" -- ";
			linea += this.detalleVentas[i].getValorUnitario()+" -- ";
			linea += this.detalleVentas[i].getCantidad()+" -- ";
			linea += this.detalleVentas[i].getValorTotal()+"\n";
		}
		return linea;
	}
}