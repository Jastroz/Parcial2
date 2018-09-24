package modelo;

public class Mundo {
	private Ventas ventas;
	private Configuracion config;

	public Mundo()
	{
		// TODO Auto-generated constructor stub
		config = new Configuracion();
		ventas = new Ventas(config.getMaxRegistros());
	}

	public Ventas getVentas() {
		return ventas;
	}

	public Configuracion getConfig() {
		return config;
	}
	
	
}