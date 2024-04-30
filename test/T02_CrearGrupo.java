package Sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class T02_CrearGrupo {
	HashSet<Usuario> u;
	Usuario brais, david;

	@BeforeEach
	void setUp() throws Exception {
		u = new HashSet<>();
		brais = new Usuario();
		david = new Usuario();
		u.add(brais);
		u.add(david);
	}

	@AfterEach
	void tearDown() throws Exception {
		u = null;
		brais = null;
		david = null;
	}

	@Test
	void testCrearGrupoCP1() {
		
		//Act
		Grupo grupoPrueba = new Grupo("grupoPrueba", u);
		
		//Assert
		assertNotNull(grupoPrueba); // Comprobamos que no sea nulo el grupo creado
		assertNotNull(grupoPrueba.nombre); // Comprobamos que el nombre no es nulo
		assertNotNull(grupoPrueba.users); // Comprobamos que el HashSet de usuarios del grupo no es nulo
		assertSame("grupoPrueba", grupoPrueba.getNombre(), "El constructor ha fallado estableciendo el nombre");
		assertEquals(u , grupoPrueba.getUsers(), "El constructor ha fallado estableciendo los usuarios");
	}

	@Test
	void testCrearGrupoCP2(){
		//Act
		Grupo grupoPrueba = new Grupo(null, u);

		//Assert
		assertNull(grupoPrueba.nombre); // Comprobamos que el nombre del grupo es nulo
		assertNotNull(grupoPrueba.users); // Comprobamos que el HashSet de usuarios no es nulo
		
	}

	@Test
	void testCrearGrupoCP3(){
		//Act
		Grupo grupoPrueba = new Grupo("grupoPrueba", null);

		//Assert
		assertNotNull(grupoPrueba.nombre); // Comprobamos que el nombre del grupo no es nulo
		assertNull(grupoPrueba.users); // Comprobamos que el HashSet de usuarios es nulo
		
	}

	@Test
	void testCrearGrupoCP4(){
		//Act
		Grupo grupoPrueba = new Grupo(null, null);

		//Assert
		assertNull(grupoPrueba.nombre); // Comprobamos que el nombre del grupo es nulo
		assertNull(grupoPrueba.users); // Comprobamos que el HashSet de usuarios es nulo
		
	}
}
