package Sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Grupo;
import entidades.Usuario;

class T04_AnhadirUsuarios {

	Grupo g1;
	HashSet<Usuario> usuarios;
	Usuario u1, u2;

	@BeforeEach
	void setUp() throws Exception {

		usuarios = new HashSet<>();
		u1 = new Usuario(2, "paula");
		u2 = new Usuario(1, "lucas");
		usuarios.add(u1);
		usuarios.add(u2);

		g1 = new Grupo("losDos", usuarios);
	}

	@AfterEach
	void tearDown() throws Exception {
		usuarios = null;
		u1 = null;
		u2 = null;
	}

	/** PRUEBAS DE CAJA NEGRA */

	/* CP1: Lista de usuarios nula, lista de retorno vacía */
	@Test
	void testCP1() {
		// Act
		ArrayList<Usuario> paramList = null;
		ArrayList<Usuario> retornoList = g1.anhadirUsuarios(paramList);

		// Assert
		assertTrue(retornoList.isEmpty());

	}

	/* CP2: Lista de usuarios válida, lista de retorno con la misma longitud */
	@Test
	void testCP2() {
		// Act
		ArrayList<Usuario> paramList = new ArrayList<>();
		Usuario u3 = new Usuario(3, "brais");
		paramList.add(u3);

		ArrayList<Usuario> retornoList = g1.anhadirUsuarios(paramList);

		// Assert
		boolean mismaLongitudListas = retornoList.size() == paramList.size(); 
		assertTrue(mismaLongitudListas);
		assertEquals(paramList, retornoList);
	}

	/** PRUEBAS DE CAJA BLANCA */

	/* CP3: Lista de usuarios vacía, lista de retorno vacía */
	@Test
	void testCP3() {
		// Act
		ArrayList<Usuario> paramList = new ArrayList<>();
		ArrayList<Usuario> retornoList = g1.anhadirUsuarios(paramList);
		HashSet<Usuario> usuariosInicial = g1.getUsers();
		
		// Assert
		assertTrue(retornoList.isEmpty());
		assertEquals(usuariosInicial, g1.getUsers());
	}

	/*
	 * CP4: Lista de usuarios con valores no válidos, lista de retorno con distinta
	 * longitud
	 */
	@Test
	void testCP4() {
		// Act
		ArrayList<Usuario> paramList = new ArrayList<>();
		Usuario u3 = new Usuario(3, "brais");
		paramList.add(u3);
		paramList.add(u1);
		
		ArrayList<Usuario> retornoList = g1.anhadirUsuarios(paramList);
		
		// Assert
		assertFalse(retornoList.isEmpty());
		boolean mismaLongitudListas = retornoList.size() == paramList.size(); 
		assertFalse(mismaLongitudListas);
		assertNotEquals(paramList, retornoList);
	}
}
