package Sprint1;

import entidades.Usuario;
import entidades.Grupo;
import entidades.Gasto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    
    /*Pruebas de Caja Negra*/
    

    /*Caso 1: cantidad válida, grupo válido, usuario válido.*/
    @Test
    void testCP1() {
        // Act
        Gasto gasto = new Gasto(25.0, grupo, paula);
        
        // Assert
        assertEquals(25.0, gasto.getCantidad()); // Verifica que la cantidad del gasto sea 25.0
        assertSame(grupo, gasto.getGrupo()); // Verifica que el grupo del gasto sea el mismo grupo creado
        assertSame(paula, gasto.getUsuarioCreador()); // Verifica que el usuario creador del gasto sea Paula
    }
    
    /*Caso 2: cantidad válida, grupo NULL, usuario válido.*/
    @Test
    void testCP2() {
        // Act
        Gasto gasto = new Gasto(50.0, null, paula);
        
        // Assert
        assertNull(gasto.getGrupo()); // Verifica que el grupo del gasto sea nulo
    }
    
    /*Caso 3: cantidad válida, grupo válido, usuario NULL.*/
    @Test
    void testCP3() {
        // Act
        Gasto gasto = new Gasto(50.0, grupo, null);
        
        // Assert
        assertNull(gasto.getUsuarioCreador()); // Verifica que el usuario creador del gasto sea nulo
    }
    
    
    /*Pruebas de caja blanca*/
    
    /*Caso 4: cantidad < 0, grupo válido, usuario válido.*/
    @Test
    void testCP4() {
        // Act
        Gasto gasto = new Gasto(-5.0, grupo, paula);
        
        // Assert
        assertNull(gasto.getCantidad()); // Verifica que la cantidad del gasto sea negativa
    }
    
    /*Caso 5: cantidad > 1000, grupo válido, usuario válido.*/
    @Test
    void testCP5() {
        // Act
        Gasto gasto = new Gasto(2000.0, grupo, paula);
        
        // Assert
        assertNull(gasto.getCantidad()); // Verifica que la cantidad del gasto no sea mayor que 1000.0
        assertNull(gasto.getGrupo());
        assertNull(gasto.getUsuarioCreador());
    }

}
