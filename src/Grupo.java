package Sprint1;

import java.util.HashSet;
import java.util.Random;

public class Grupo {

    Integer id;
    String nombre;
    HashSet<Usuario> users;

    public Grupo(String nombre, HashSet<Usuario> users) {
        id = new Random().nextInt();
        nombre = this.nombre;
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
    
    
}
