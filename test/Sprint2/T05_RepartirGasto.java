package Sprint2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class T05_RepartirGasto {

	private Grupo g;
	private Usuario pepe;
	private Usuario juan;
	private ArrayList<Usuario> users;

	
	
	@BeforeEach
	void setUp() throws Exception {
		g = new Grupo();
		users = new ArrayList<>();
		pepe = new Usuario(1,"pepe");
		juan = new Usuario(2,"juan");
	}
	
	/*CAJA NEGRA*/
	
	/*Acreedor valido, gasto valido*/
	@Test
	void CP1() {
		
		//Act
		Usuario acreedor = new Usuario(3,"david");
		Gasto gasto = new Gasto(100.0,g,acreedor);
		users.add(pepe);
		users.add(juan);
		g.anhadirUsuarios(users);
		Amortizacion a = new Amortizacion(100.0,acreedor,juan);
		
		//Assert
		assertTrue(g.anadirGasto(acreedor, gasto).contains(a));
		assertTrue(g.anadirGasto(acreedor, gasto).size() == 2);
		
	}
	
	/*Acreedor NULL,gasto valido*/
	@Test
	void CP2() {
		//Act
			Usuario acreedor = null;
				Gasto gasto = new Gasto(100.0,g,acreedor);
				users.add(pepe);
				users.add(juan);
				g.anhadirUsuarios(users);
				g.anadirGasto(acreedor, gasto);
				
				//Assert
				assertNull(g.anadirGasto(null, gasto));
	}
	
	@Test
	void CP3() {
		//Act
				Usuario acreedor = new Usuario(3,"david");
				users.add(pepe);
				users.add(juan);
				g.anhadirUsuarios(users);
				
				//Assert
				assertNull(g.anadirGasto(acreedor, null));
	}

}
