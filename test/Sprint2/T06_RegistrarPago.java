package Sprint2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Amortizacion;
import entidades.Usuario;

class T06_RegistrarPago {

    Usuario usuario1;
    Usuario usuario2;
    Amortizacion amortizacionPendiente;
    Amortizacion amortizacionPagada;

    @BeforeEach
    void setUp() {
        // Crear usuarios
        usuario1 = new Usuario(1, "Lucas");
        usuario2 = new Usuario(2, "Paula");

        // Crear amortizaciones
        amortizacionPendiente = new Amortizacion(100.0, usuario2, usuario1);
        amortizacionPagada = new Amortizacion(150.0, usuario1, usuario2);
        amortizacionPagada.amortizar(); // Marcar como pagada

        // Asignar amortizaciones a usuarios
        usuario1.getAmortizaciones().add(amortizacionPendiente);
        usuario2.getAmortizaciones().add(amortizacionPagada);
    }

    @AfterEach
    void tearDown() {
        // Limpiar los datos después de cada prueba
        usuario1 = null;
        usuario2 = null;
        amortizacionPendiente = null;
        amortizacionPagada = null;
    }
    
    //CP1: Pagar amortización pendiente
    @Test
    void testPagarAmortizacionPendiente() {
        // Act
        usuario1.pagar(usuario2);

        // Assert
        assertTrue(amortizacionPendiente.getPagado());
        assertTrue(amortizacionPagada.getPagado());
    }

    //CP2: Pagar amortización ya pagada
    @Test
    void testPagarAmortizacionYaPagada() {
        // Act
        usuario2.pagar(usuario1);

        // Assert
        assertFalse(amortizacionPendiente.getPagado());
        assertTrue(amortizacionPagada.getPagado());
    }

    //CP3: Intentar pagar amortización inexistente
    @Test
    void testPagarAmortizacionInexistente() {
        // Crear un nuevo usuario sin amortizaciones
        Usuario usuario3 = new Usuario(3, "Sergio");

        // Act
        usuario3.pagar(usuario1);

        // Assert
        // No debería haber cambios, ya que no hay amortizaciones para pagar
        assertFalse(amortizacionPendiente.getPagado());
        assertTrue(amortizacionPagada.getPagado());
    }
}
