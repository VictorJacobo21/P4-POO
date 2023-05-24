package vj.cardshark;

import org.junit.Test;
import static org.junit.Assert.*;

public class ColorTest {

    @Test
    public void testEnumValues() {
        // Verificar los valores de la enumeración
        assertEquals(Color.ROJO, Color.valueOf("ROJO"));
        assertEquals(Color.NEGRO, Color.valueOf("NEGRO"));
    }
}
