package Sprint1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Grupo {

    Integer id;
    String nombre;
    HashSet<Usuario> users;

    public Grupo(String nombre, HashSet<Usuario> users) {
        id = new Random().nextInt();
        this.nombre = nombre;
        setUsers(users);

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
        this.nombre = nombre;
    }
    
    
	public void anadirGasto(Gasto gasto) {
	
	}

	public void anhadirUsuario(Usuario u) {
		if(u != null && !this.users.contains(u)) {
			this.users.add(u);
			System.out.println("Usuario " + u + " anhadido correctamente al grupo.");
		}
		else {
			System.out.println("Error: el usuario " + u + " no existe o ya esta incluido en el grupo.");
		}
	}
	
	public void anhadirMultiplesUsuarios(ArrayList<Usuario> usuarios) {
		if(usuarios != null && !usuarios.isEmpty()) {
			for(Usuario u : usuarios) {
				anhadirUsuario(u);
			}
			System.out.println("Los usuarios han sido anhadidos correctamente al grupo.");
		}
		else {
			System.out.println("Error: la lista no existe o está vacía.");
		}
	}
}
