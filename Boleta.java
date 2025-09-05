package GB;

public class Boleta {
	private int cod;
	private String prod;
	private double precio;
	public Boleta(int cod, String prod, double precio) {
		super();
		this.cod = cod;
		this.prod = prod;
		this.precio = precio;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getProd() {
		return prod;
	}
	public void setProd(String prod) {
		this.prod = prod;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
