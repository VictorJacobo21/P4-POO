package vj.cardshark;

import org.junit.Test;
import static org.junit.Assert.*;

public class CartaTest {

    @Test
    public void testGetValor() throws FueraDeRangoException {
        // Crea una carta con valor 5 y figura CORAZONES
        Carta carta = new Carta(5, Figura.CORAZONES);

        // Verifica que el valor de la carta sea 5
        assertEquals(5, carta.getValor());
    }

    @Test
    public void testGetFigura() throws FueraDeRangoException {
        // Crea una carta con valor 10 y figura PICAS
        Carta carta = new Carta(10, Figura.PICAS);

        // Verifica que la figura de la carta sea PICAS
        assertEquals(Figura.PICAS, carta.getFigura());
    }

    @Test
    public void testGetColor() throws FueraDeRangoException {
        // Crea una carta con valor 1 (A) y figura DIAMANTES
        Carta carta1 = new Carta(1, Figura.DIAMANTES);

        // Verifica que el color de la carta sea ROJO
        assertEquals(Color.ROJO, carta1.getColor());

        // Crea una carta con valor 13 (K) y figura TREBOLES
        Carta carta2 = new Carta(13, Figura.TREBOLES);

        // Verifica que el color de la carta sea NEGRO
        assertEquals(Color.NEGRO, carta2.getColor());
    }

    @Test
    public void testToString() throws FueraDeRangoException {
        // Crea una carta con valor 2 y figura TREBOLES
        Carta carta = new Carta(2, Figura.TREBOLES);

        // Verifica que la representación en cadena de la carta sea "2:TREBOLES"
        assertEquals("2:TREBOLES", carta.toString());
    }

    @Test
    public void testCompareTo() throws FueraDeRangoException {
        // Crea dos cartas con el mismo valor (5) pero diferentes figuras
        Carta carta1 = new Carta(5, Figura.CORAZONES);
        Carta carta2 = new Carta(5, Figura.PICAS);

        // Verifica que ambas cartas sean iguales en términos de orden
        assertEquals(0, carta1.compareTo(carta2));

        // Crea dos cartas con diferentes valores y figuras
        Carta carta3 = new Carta(10, Figura.DIAMANTES);
        Carta carta4 = new Carta(8, Figura.TREBOLES);

        // Verifica que la carta3 sea mayor que la carta4
        assertTrue(carta3.compareTo(carta4) > 0);

        // Verifica que la carta4 sea menor que la carta3
        assertTrue(carta4.compareTo(carta3) < 0);
    }
}
