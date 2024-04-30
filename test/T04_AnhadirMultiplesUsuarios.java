package Sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class T04_AnhadirMultiplesUsuarios {
	
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

	/* CP1: Lista de usuarios válida, inserción exitosa*/
	@Test
	void testCP1() {
		//Act
		ArrayList<Usuario> uList = new ArrayList<>();
		Usuario u3 = new Usuario(3, "brais");
		uList.add(u3);
		
		g1.anhadirMultiplesUsuarios(uList);
		
		//Assert
		assertTrue(g1.getUsers().contains(u3));
		
	}
	
	/* CP2: Lista de usuarios nula, error*/
	@Test
	void testCP2() {
		//Act
		ArrayList<Usuario> uList = null;
		HashSet<Usuario> usuariosOG = g1.getUsers(); // Lista de usuarios original del grupo, previa a la inserción
		g1.anhadirMultiplesUsuarios(uList);
		
		//Assert
		assertEquals(usuariosOG, g1.getUsers());
		
	}

}
