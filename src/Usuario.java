package Sprint1;

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
        if (id != null) {
            this.id = id;
            if (nombre != null) {
                if (nombre.matches("^[a-zA-Z0-9]+$")) {
                    this.nombre = nombre;
                    this.amortizaciones = new ArrayList<Amortizacion>();
                } else {
                    //lanzar excepcion
                    //System.out.println("nombre no puede contener otra cosa que numeros y letras");
                }

            }else {
                    //lanzar excepcion
                    //System.out.println("nombre no puede ser nulo");
                }
        } else {
            //lanzar excepcion
            //System.out.println("ID no puede ser nulo");
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
    
    public void addAmortizacion(Usuario acreedor, Double cantidad) {
    	
    	for(Amortizacion amortizacion : this.amortizaciones) {
    		if (amortizacion.getAcreedor().equals(acreedor)) {
    			if(!amortizacion.getPagado()) {
    				amortizacion.setCantidad(amortizacion.getCantidad() + cantidad);
    			} else {
    				amortizacion.setCantidad(cantidad);
    				amortizacion.setPagado(false);
    			}
    		}
    	}
    	
    }
    
    public List<Amortizacion> consultarAmortizaciones() {
    	
    	List<Amortizacion> deudasPendientes = new ArrayList<Amortizacion>();
    	
    	for(Amortizacion amortizacion : this.amortizaciones) {
    		if (!amortizacion.getPagado()) {
    			deudasPendientes.add(amortizacion);
    		}
    	}
    	
    	return deudasPendientes;
    }
    
    public void pagar(Usuario acreedor) {
    	
    	for(Amortizacion amortizacion : this.amortizaciones) {
    		if (amortizacion.getAcreedor().equals(acreedor)) {
    			if(!amortizacion.getPagado()) {
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
