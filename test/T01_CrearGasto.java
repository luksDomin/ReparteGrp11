package Sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Grupo;
import entidades.Usuario;
import entidades.Gasto;

class T01_CrearGasto {

	Usuario paula;
	Grupo grupo;

	@BeforeEach
	void setUp() throws Exception {
		paula = new Usuario(01, "Paula");
		HashSet<Usuario> usuarios = new HashSet<Usuario>();
		usuarios.add(paula);
		grupo = new Grupo("Grupo1", usuarios);
	}

	/* Caso 1: cantidad válida, grupo válido, usuario válido. */
	@Test
	void testCP1() {
		// Act
		Gasto gasto = new Gasto(25.0, grupo, paula);

		// Assert
		assertNotNull(gasto); // Verifica que el gasto no sea nulo
		assertEquals(25.0, gasto.getCantidad()); // Verifica que la cantidad del gasto sea 25.0
		assertSame(grupo, gasto.getGrupo()); // Verifica que el grupo del gasto sea el mismo grupo creado
		assertSame(paula, gasto.getUsuarioCreador()); // Verifica que el usuario creador del gasto sea Paula
	}

	/* Caso 2: cantidad < 0, grupo válido, usuario válido. */
	@Test
	void testCP2() {
		// Act
		Gasto gasto = new Gasto(-5.0, grupo, paula);

		// Assert
		assertTrue(gasto.getCantidad() < 0); // Verifica que la cantidad del gasto sea negativa
	}

	/* Caso 3: cantidad > 1000, grupo válido, usuario válido. */
	@Test
	void testCP3() {
		// Act
		Gasto gasto = new Gasto(2000.0, grupo, paula);

		// Assert
		assertFalse(gasto.getCantidad() > 1000.0); // Verifica que la cantidad del gasto no sea mayor que 1000.0
	}

	/* Caso 4: cantidad válida, grupo NULL, usuario válido. */
	@Test
	void testCP4() {
		// Act
		Gasto gasto = new Gasto(50.0, null, paula);

		// Assert
		assertNull(gasto.getGrupo()); // Verifica que el grupo del gasto sea nulo
	}

	/* Caso 5: cantidad válida, grupo válido, usuario NULL. */
	@Test
	void testCP5() {
		// Act
		Gasto gasto = new Gasto(50.0, grupo, null);

		// Assert
		assertNotNull(gasto.getUsuarioCreador()); // Verifica que el usuario creador del gasto no sea nulo
	}

	/* Caso 6: cantidad == 1001 (caso límite), grupo válido, usuario válido. */
	@Test
	void testCP6() {
		// Act
		Gasto gasto = new Gasto(1001.0, grupo, paula);

		// Assert
		assertEquals(1001.0, gasto.getCantidad(), 0.01); // Verifica que la cantidad del gasto sea 1001.0 con un margen
															// de error de 0.01
	}

}
