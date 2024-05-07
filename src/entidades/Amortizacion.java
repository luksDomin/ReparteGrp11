package entidades;

import java.util.Objects;

public class Amortizacion {

	Double cantidad;
	boolean pagado;
	Usuario acreedor; // Persona que deja el dinero.
	Usuario deudor; // Persona que debe dinero.

	public Amortizacion(Double cantidad, Usuario acreedor, Usuario deudor) {
		super();
		this.cantidad = cantidad;
		this.acreedor = acreedor;
		this.deudor = deudor;
		this.pagado = false;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	public Usuario getAcreedor() {
		return acreedor;
	}

	public void setAcreedor(Usuario acreedor) {
		this.acreedor = acreedor;
	}

	public Usuario getDeudor() {
		return deudor;
	}

	public void setDeudor(Usuario deudor) {
		this.deudor = deudor;
	}

	public void amortizar() {
		this.setPagado(true);
	}
	
	
	@Override
	public boolean equals(Object o) {
	    // self check
	    if (this == o)
	        return true;
	    // null check
	    if (o == null)
	        return false;
	    // type check and cast
	    if (getClass() != o.getClass())
	        return false;
	    Amortizacion a = (Amortizacion) o;
	    // field comparison
	    return Objects.equals(acreedor.getNombre(), a.acreedor.getNombre())
	            && Objects.equals(deudor.getNombre(), a.deudor.getNombre());
	}

}
