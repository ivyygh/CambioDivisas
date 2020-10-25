package fxJava.CambioDivisas;

public class Divisas {	

	private String nombre;
	private Double tasa;

	public Divisas(String nombre, Double tasa) {
		super();
		this.nombre = nombre;
		this.tasa = tasa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getTasa() {
		return tasa;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	
	public Double fromEuro(Double euros) {
		return euros * tasa;
	}

	public Double toEuro(Double moneda) {
		return moneda / tasa;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	public static Double fromTo(Divisas from, Divisas to, Double cantidad) {
		return to.fromEuro(from.toEuro(cantidad));
	}

}
