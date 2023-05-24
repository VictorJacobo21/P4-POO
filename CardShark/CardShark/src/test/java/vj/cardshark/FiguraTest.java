package vj.cardshark;

import org.junit.Test;
import static org.junit.Assert.*;

public class FiguraTest {

    @Test
    public void testFiguras() {
        // Verificar las figuras
        assertEquals(Figura.CORAZONES, Figura.CORAZONES);
        assertEquals(Figura.PICAS, Figura.PICAS);
        assertEquals(Figura.DIAMANTES, Figura.DIAMANTES);
        assertEquals(Figura.TREBOLES, Figura.TREBOLES);
    }

}
