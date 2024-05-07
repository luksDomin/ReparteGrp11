package entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Grupo {

    Integer id;
    String nombre;
    HashSet<Usuario> users;

    public Grupo() {
    	this.users = new HashSet<>();
    }

    public Grupo(String nombre, HashSet<Usuario> users) {
        if (nombre != null) {
            if (nombre.matches("^[a-zA-Z0-9]+$")) {
                if (users != null) {
                    if (!users.isEmpty()) {
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
        if (nombre != null) {
            this.nombre = nombre;
        }
    }

    public ArrayList<Amortizacion>  anadirGasto(Usuario acreedor, Gasto gasto) {
    	ArrayList<Amortizacion> amortizaciones_creadas = null;
        if (acreedor != null && gasto != null) {

            int numUsuarios = this.getUsers().size();

            Double cantidad = gasto.getCantidad();

            if (cantidad != null) {
                Double cantidadRepartida = cantidad / numUsuarios;

                for (Usuario miembroGrupo : this.getUsers()) {
                	if(miembroGrupo.getNombre().equals(acreedor.getNombre()))continue;
                	if(amortizaciones_creadas == null) amortizaciones_creadas = new ArrayList<>();
                	amortizaciones_creadas.add(miembroGrupo.addAmortizacion(acreedor, cantidadRepartida));
                }
            }
        }
        return amortizaciones_creadas;
    }

    public ArrayList<Usuario> anhadirUsuarios(ArrayList<Usuario> usuarios) {
        ArrayList<Usuario> usuariosAnhadidos = new ArrayList<Usuario>(); // Lista de usuarios que se añadiran al Grupo
        if (usuarios != null) {
            for (Usuario usuario : usuarios) {
                if (usuario != null && !this.users.contains(usuario)) { // si es un usuario válido
                    // inserción del usuario correcta, se añade a la lista que se usará como retorno
                    this.users.add(usuario);
                    usuariosAnhadidos.add(usuario);
                }
            }
        }
        /*
		 * si la lista que se recibe como argumento no esta inicializada se devuelve una
		 * lista de usuarios vacia (no se añadió ninguno)
		 *
		 * si la lista que se recibe como argumento está vacía se devuelve una lista de
		 * usuarios vacia (no se añadió ninguno)
		 *
		 * si se ha añadido algun usuario al Grupo, la lista que se devuelve contendrá
		 * al menos un usuario
         */
        return usuariosAnhadidos;
    }

    public ArrayList<Usuario> eliminarUsuarios(ArrayList<Usuario> usuarios) {
        // Lista de usuarios que se eliminarán del Grupo
        ArrayList<Usuario> usuariosEliminados = new ArrayList<Usuario>();
        if (usuarios != null) {
            for (Usuario usuario : usuarios) {
                if (usuario != null && this.users.contains(usuario)) { // si es un usuario válido
                    // usuario eliminado, se añade a la lista que se usará como retorno
                    this.users.remove(usuario);
                    usuariosEliminados.add(usuario);
                }
            }
        }
        /*
		 * - si la lista que se recibe como argumento no esta inicializada se devuelve
		 * una lista de usuarios vacia (no se eliminó ninguno)
		 * 
		 * - si la lista que se recibe como argumento está vacía se devuelve una lista
		 * de usuarios vacia (no se eliminó ninguno)
		 *
		 * - si se ha eliminado algun usuario del Grupo, la lista que se devuelve
		 * contendrá al menos un usuario
         */
        return usuariosEliminados;
    }
}
