package Sprint2;

import entidades.Amortizacion;
import entidades.Grupo;
import entidades.Usuario;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lucas
 */
public class T09_ConsultarAmortizaciones {

    public T09_ConsultarAmortizaciones() {
    }

    Usuario user;
    Usuario user2;

    Grupo grupo;

    @BeforeEach
    void setUp() throws Exception {
        this.user = new Usuario(1, "Lucas");
        this.user2 = new Usuario(2, "Paula");

        HashSet<Usuario> usuarios = new HashSet<>();
        usuarios.add(user);
        usuarios.add(user2);

        this.grupo = new Grupo("GrupoPrueba", usuarios);
        user.crearGasto(20.0, grupo);
    }

    @AfterEach
    void tearDown() throws Exception {
        this.user = null;
        this.user2 = null;
        this.grupo = null;
    }

    //Caja Negra
    //Se compruba que una vez creado el gasto hay amortizaciones
    @Test
    void CP1() {

        List<Amortizacion> amortizaciones = this.user2.consultarAmortizaciones();

        Boolean tieneAmortizaciones;
        if (!amortizaciones.isEmpty()) {
            tieneAmortizaciones = true;
        } else {
            tieneAmortizaciones = false;
        }

        assertTrue(tieneAmortizaciones);
    }

    //Se compruba que una vez pagado el gasto no hay amortizaciones
    @Test
    void CP2() {
        this.user2.pagar(user);

        Boolean tieneAmortizaciones;
        if (this.user2.consultarAmortizaciones().isEmpty()) {
            tieneAmortizaciones = true;
        } else {
            tieneAmortizaciones = false;
        }

        assertTrue(tieneAmortizaciones);
    }

    //se comprueba que no tiene ninguna amortizacion quien crea el gasto
    @Test
    void CP3() {
        Boolean tieneAmortizaciones;
        if (this.user.consultarAmortizaciones().isEmpty()) {
            tieneAmortizaciones = true;
        } else {
            tieneAmortizaciones = false;
        }
        
        assertTrue(tieneAmortizaciones);
    }
}
