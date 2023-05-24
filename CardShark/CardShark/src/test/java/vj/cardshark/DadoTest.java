package vj.cardshark;

import org.junit.Test;
import static org.junit.Assert.*;

public class DadoTest {

    @Test
    public void testLanzar() {
        // Crear un dado
        Dado dado = new Dado();

        // Lanzar el dado varias veces y verificar que los resultados estén dentro del rango
        for (int i = 0; i < 100; i++) {
            int resultado = dado.lanzar();
            assertTrue(resultado >= 1 && resultado <= 6);
        }
    }
}
