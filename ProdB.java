package GB;

public class ProdB {
	private Boleta bl;
	private double cant;
	public ProdB(Boleta bl, double cant) {
		super();
		this.bl = bl;
		this.cant = cant;
	}
	public Boleta getBl() {
		return bl;
	}
	public void setBl(Boleta bl) {
		this.bl = bl;
	}
	public double getCant() {
		return cant;
	}
	public void setCant(double cant) {
		this.cant = cant;
	}
	public double total() {
		return bl.getPrecio()*cant;
	}

}
