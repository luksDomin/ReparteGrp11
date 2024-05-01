package Sprint1;

import java.util.Random;

public class Gasto {
	private final Integer valorMin = 1;
	private final Integer valorMax = 1000;
	private Integer id;
	private Double cantidad;
	private Grupo grupo;
	private Usuario usuarioCreador; // El que lo crea es el que lo pagó (el acreedor).
	
	public Gasto() {
		
	}
	
	public Gasto(Double cantidad, Grupo grupo, Usuario usuarioCreador) {
		if(cantidad < valorMin || cantidad > valorMax) {
			//lanzar excecpcion
			System.out.println("Valor cantidad incorrecto");
			
		}
		if(grupo == null) {
			//lanzar excecpcion
			System.out.println("Valor de grupo NULL");
		}
		if(usuarioCreador == null) {
			//lanzar excecpcion
			System.out.println("Valor de UsuarioCreador NULL");
		}
		this.id = new Random().nextInt();
		this.cantidad = cantidad;
		this.grupo = grupo;
		grupo.anadirGasto(usuarioCreador, this);
		this.usuarioCreador = usuarioCreador;
	}

	public Integer getId() {
		return id;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		if(cantidad >= 1 && cantidad <= 1000)
			this.cantidad = cantidad;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		if(grupo != null)
			this.grupo = grupo;
	}

	public Usuario getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(Usuario usuarioCreador) {
		if(usuarioCreador != null)
			this.usuarioCreador = usuarioCreador;
	}
	

	
}
