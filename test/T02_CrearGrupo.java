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
	

	/*Pruebas de caja negra*/
	
	/*CP1: Nombre del grupo nulo.*/
	@Test
	void testCrearGrupoCP1(){
		//Act
		Grupo grupoPrueba = new Grupo(null, u);

		//Assert
		assertNull(grupoPrueba.getNombre()); // Comprobamos que el nombre del grupo es nulo
		
	}
	
	/*CP3: HashSet de usuarios nulo.*/
	@Test
	void testCrearGrupoCP3(){
		//Act
		Grupo grupoPrueba = new Grupo("nombreGrupo", null);

		//Assert
		assertNull(grupoPrueba.getUsers()); // Comprobamos que el HashSet de usuarios es nulo
		
	}
	
	/*CP5: Grupo creado correctamente.*/
	@Test
	void testCrearGrupoCP5() {
		
		//Act
		Grupo grupoPrueba = new Grupo("grupoPrueba", u);
		
		//Assert
		assertNotNull(grupoPrueba); // Comprobamos que no sea nulo el grupo creado
		assertNotNull(grupoPrueba.nombre); // Comprobamos que el nombre no es nulo
		assertNotNull(grupoPrueba.users); // Comprobamos que el HashSet de usuarios del grupo no es nulo
		assertSame("grupoPrueba", grupoPrueba.getNombre(), "El constructor ha fallado estableciendo el nombre");
		assertEquals(u , grupoPrueba.getUsers(), "El constructor ha fallado estableciendo los usuarios");
	}
	
	
	
	/*Pruebas de caja blanca*/
	
	/*CP2: Nombre del grupo contiene caracteres que no son letras o números.*/
	@Test
	void testCrearGrupoCP2() {
		
		//Act
		Grupo grupoPrueba = new Grupo("gru-po", u);
		
		//Assert
		assertNull(grupoPrueba.getNombre()); // Comprobamos que el grupo no se ha creado.
	}
	
	/*CP4: HashSet de usuarios vacío*/
	@Test
	void testCrearGrupoCP4() {
		
		HashSet<Usuario> usuariosVacio = new HashSet<Usuario>();
		
		//Act
		Grupo grupoPrueba = new Grupo("grupoPrueba", usuariosVacio);
		
		//Assert
		assertNull(grupoPrueba.getUsers()); // Comprobamos que el grupo no se ha creado.
	}
}
