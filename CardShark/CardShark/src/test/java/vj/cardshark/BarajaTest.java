package vj.cardshark;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class BarajaTest {

    @Test
    public void testBarajar() {
        // Crea una baraja
        Baraja baraja = new Baraja();

        // Obtiene el orden original de las cartas
        ArrayList<Carta> ordenOriginal = new ArrayList<>(baraja.getCartas());

        // Baraja las cartas
        baraja.barajar();

        // Obtiene el nuevo orden de las cartas después de barajar
        ArrayList<Carta> nuevoOrden = new ArrayList<>(baraja.getCartas());

        // Verifica que el nuevo orden sea diferente al orden original
        assertNotEquals(ordenOriginal, nuevoOrden);
    }

    @Test
    public void testRepartir() {
        // Crea una baraja
        Baraja baraja = new Baraja();

        // Realiza una prueba de repartir 3 cartas
        int cantidadCartas = 3;
        ArrayList<Carta> mano = baraja.repartir(cantidadCartas);

        // Verifica que la cantidad de cartas en la mano sea igual a la cantidad solicitada
        assertEquals(cantidadCartas, mano.size());

        // Verifica que las cartas repartidas ya no estén en la baraja
        for (Carta carta : mano) {
            assertFalse(baraja.getCartas().contains(carta));
        }
    }

    @Test
    public void testAgregarCarta() throws FueraDeRangoException {
        // Crea una baraja
        Baraja baraja = new Baraja();

        // Crea una nueva carta y la agrega a la baraja
        Carta carta = new Carta(6, Figura.PICAS);
        baraja.agregarCarta(carta);

        // Verifica que la carta esté presente en la baraja
        assertTrue(baraja.getCartas().contains(carta));
    }

    @Test
    public void testToString() {
        // Crea una baraja
        Baraja baraja = new Baraja();

        // Obtiene la representación en cadena de la baraja
        String barajaStr = baraja.toString();

        // Verifica que la representación en cadena no esté vacía
        assertNotNull(barajaStr);
    }
}
