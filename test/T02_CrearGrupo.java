package Sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class T02_CrearGrupo {
	Grupo g;
	HashSet<Usuario> u;
	Usuario brais, david;

	@BeforeEach
	void setUp() throws Exception {
		g = new Grupo();
		g.users = new HashSet<>();
		u = new HashSet<>();
		brais = new Usuario();
		david = new Usuario();
	}

	@AfterEach
	void tearDown() throws Exception {
		g = null;
		u = null;
		brais = null;
		david = null;
	}

	@Test
	void testCrearGrupo() {
		
		//Act
		g.setNombre("grupoPrueba");
		u.add(brais);
		u.add(david);
		g.setUsers(u);
		Grupo grupoPrueba = new Grupo("grupoPrueba", u);
		
		//Assert
		assertNotNull(u); // Comprobamos que no sea nulo el HashSet de usuarios
		assertNotNull(g.nombre); // Comprobamos que el nombre no es nulo
		assertNotNull(g.users); // Comprobamos que el HashSet de usuarios del grupo no es nulo
		assertEquals(g.getNombre(), grupoPrueba.getNombre(), "El constructor ha fallado estableciendo el nombre");
		assertEquals(g.getUsers(), grupoPrueba.getUsers(), "El constructor ha fallado estableciendo los usuarios");
	}

}