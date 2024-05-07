package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {

	private Integer id;
	private String nombre;
	private List<Amortizacion> amortizaciones;

	public Usuario() {

	}

	public Usuario(Integer id, String nombre) {
		if (id != null)
			if (nombre != null)
				if (nombre.matches("^[a-zA-Z0-9]+$")) {
					this.id = id;
					this.nombre = nombre;
					this.amortizaciones = new ArrayList<Amortizacion>();
				}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Amortizacion> getAmortizaciones() {
		return amortizaciones;
	}

	public void setAmortizaciones(List<Amortizacion> amortizaciones) {
		this.amortizaciones = amortizaciones;
	}

	public void crearGasto(Double cantidad, Grupo grupo) {
		Gasto g = new Gasto(cantidad, grupo, this);
	}

	
	public Amortizacion addAmortizacion(Usuario acreedor, Double cantidad) {
		int encontrado = 0;
		Amortizacion a = null;
		// Nuevas amortizaciones
		for (Amortizacion amortizacion : this.amortizaciones) {
			if (amortizacion.getAcreedor().equals(acreedor)) {
				encontrado = 1;
				if (amortizacion.getPagado()) {
					amortizacion.setCantidad(cantidad);
					amortizacion.setPagado(false);
				}else {
					amortizacion.setCantidad(amortizacion.getCantidad() + cantidad);
				}
				a = amortizacion;
			}
		}
		if(encontrado == 0) {
			a = new Amortizacion(cantidad,acreedor,this);
			a.setPagado(false);
			this.amortizaciones.add(a);

		}
		return a;
	}

	public List<Amortizacion> consultarAmortizaciones() {

		List<Amortizacion> deudasPendientes = new ArrayList<Amortizacion>();

		for (Amortizacion amortizacion : this.amortizaciones) {
			if (!amortizacion.getPagado()) {
				deudasPendientes.add(amortizacion);
			}
		}

		return deudasPendientes;
	}

	public void pagar(Usuario acreedor) {

		for (Amortizacion amortizacion : this.amortizaciones) {
			if (amortizacion.getAcreedor().equals(acreedor)) {
				if (!amortizacion.getPagado()) {
					amortizacion.amortizar();
				}
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
}
