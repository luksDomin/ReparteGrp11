package Sprint1;

public class Usuario {

	public void crearGasto(Double cantidad, Grupo grupo){
		Gasto g = new Gasto(cantidad, grupo, this);
	}
}
