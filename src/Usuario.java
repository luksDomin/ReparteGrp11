package Sprint1;

public class Usuario {

    private Integer id;
    private String nombre;

    public Usuario() {

    }

    public Usuario(Integer id, String nombre) {
        if (id != null) {
            this.id = id;
            if (nombre != null) {
                if (nombre.matches("^[a-zA-Z0-9]+$")) {
                    this.nombre = nombre;
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

    public void crearGasto(Double cantidad, Grupo grupo) {
        Gasto g = new Gasto(cantidad, grupo, this);
    }
}
