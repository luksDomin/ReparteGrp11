package Sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class T01_CrearGasto {
	
	Usuario paula;
	Grupo grupo;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		paula = new Usuario(01, "Paula");
        HashSet<Usuario> usuarios = new HashSet<Usuario>();
        usuarios.add(paula);
        grupo = new Grupo("Grupo1", usuarios);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    void testCP1() {
		// Act
        Gasto gasto = new Gasto(25.0, grupo, paula);
        
        // Assert
        assertNotNull(gasto); // Verifica que el gasto no sea nulo.
    }
	
	@Test
    void testCP2() {
		// Act
        Gasto gasto = new Gasto(-5.0, grupo, paula);
        
        // Assert
        assertNotNull(gasto.getGrupo()); // Verifica que el grupo del gasto no sea nulo
    }

}
