package Sprint1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Grupo {

	Integer id;
	String nombre;
	HashSet<Usuario> users;

	public Grupo() {

	}

	public Grupo(String nombre, HashSet<Usuario> users) {
    	
    	if(nombre == null) {
    		//EXCEPCION O RETURN
			System.out.println("El nombre del grupo debe ser no nulo");
    	} else {
    	
	    	if(!nombre.matches("^[a-zA-Z0-9]+$")) {
	    		//EXCEPCION O RETURN
				System.out.println("El nombre del grupo debe estar formado por letras y números");
	    	} else {
	    	
		    	if(users.equals(null)) {
		    		//EXCEPCION O RETURN
					System.out.println("El grupo de usuarios debe ser no nulo");
		    	} else {
		    	
			    	if(users.isEmpty()) {
			    		//EXCEPCION O RETURN
						System.out.println("El grupo de usuarios no puede estar vacío");
			    	} else {
			    	
				        id = new Random().nextInt();
				        this.nombre = nombre;
				        this.users = users;
			    	}
		    	}
	    	}
    	}
    }

	public HashSet<Usuario> getUsers() {
		return users;
	}

	public void setUsers(HashSet<Usuario> users) {
		if (users != null && !users.isEmpty()) {
			this.users.addAll(users);
		}
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null)
			this.nombre = nombre;
	}

	
	
	public void anadirGasto(Usuario acreedor, Gasto gasto) {
		
		int numUsuarios = this.getUsers().size();
		Double cantidadRepartida = gasto.getCantidad() / numUsuarios;
		
		for(Usuario miembroGrupo : this.getUsers()) {
			miembroGrupo.addAmortizacion(acreedor, cantidadRepartida);
		}
		
	}

	public void anhadirMultiplesUsuarios(ArrayList<Usuario> usuarios) {
		if (usuarios != null) {
			for (Usuario u : usuarios) {
				if (u != null && !this.users.contains(u)) {
					this.users.add(u);
					// System.out.println("Usuario " + u + " anhadido correctamente al grupo.");
				} else {
					// EXCEPCION o RETURN
					// System.out.println("Error: el usuario " + u + " no existe o ya esta incluido
					// en el grupo.");
				}
			}
		} else {
			// EXCEPCION o RETURN
			// System.out.println("Error: la lista no existe o está vacía.");
		}
	}

	public void eliminarMultiplesUsuarios(ArrayList<Usuario> usuarios) {
		if (usuarios != null && !usuarios.isEmpty()) {
			for (Usuario u : usuarios) {
				if (u != null && !this.users.contains(u)) {
					this.users.remove(u);
					// System.out.println("Usuario " + u + " eliminado correctamente del grupo.");
				} else {
					// EXCEPCION o RETURN
					// System.out.println("Error: el usuario " + u + " no existe o ya no esta
					// incluido en el grupo.");
				}
			}
		} else {
			// EXCEPCION o RETURN
			// System.out.println("Error: la lista no existe o está vacía.");
		}
	}
}
