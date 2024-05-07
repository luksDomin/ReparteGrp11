package Sprint1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import entidades.Usuario;

class T03_CrearUsuario {

	// Caja negra
	@Test
	void CP1() {
		// Caso 1: ID positivo, nombre válido.
		int id1 = 123;
		String nombre1 = "Juan";
		Usuario usuario1 = new Usuario(id1, nombre1);
		assertEquals(nombre1, usuario1.getNombre());
		assertEquals(id1, usuario1.getId());
	}

	@Test
	void CP2() {
		// Caso 2: ID negativo, nombre válido.
		int id2 = -456;
		String nombre2 = "juan";
		Usuario usuario2 = new Usuario(id2, nombre2);
		assertTrue(usuario2.getId() < 0);
		assertEquals("juan", usuario2.getNombre());
	}

	@Test
	void CP3() {
		// Caso 4: ID válido, nombre nulo.
		int id4 = 789;
		String nombre4 = null;
		Usuario usuario4 = new Usuario(id4, nombre4);
		assertNull(usuario4.getNombre());
	}

	// caja blanca
	@Test
	void CP4() {
		int id = 789;
		String nombreMalo = "pep.e";
		Usuario usuario = new Usuario(id, nombreMalo);
		assertNull(usuario.getNombre());
	}

}
