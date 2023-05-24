package vj.cardshark;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class JugadorTest {

    @Test
    public void testRemoverCarta() throws FueraDeRangoException {
        // Crea un jugador
        Jugador jugador = new Jugador("Jugador1");

        // Crea una carta y añádela a la mano del jugador
        Carta carta = new Carta(4, Figura.CORAZONES);
        jugador.getMano().add(carta);

        // Remueve la carta del jugador
        jugador.removerCarta(carta);

        // Verifica que la carta haya sido removida correctamente
        assertFalse(jugador.getMano().contains(carta));
    }

    @Test
    public void testGenerarMano() {
        // Crea un jugador
        Jugador jugador = new Jugador("Jugador1");

        // Genera una mano para el jugador
        jugador.generarMano();

        // Verifica que la mano tenga 5 cartas
        assertEquals(5, jugador.getMano().size());
    }

    @Test
    public void testGetId() {
        // Crea un jugador con un ID específico
        String id = "Jugador1";
        Jugador jugador = new Jugador(id);

        // Obtiene el ID del jugador y verifica que sea igual al ID especificado
        assertEquals(id, jugador.getId());
    }

    @Test
    public void testSetMano() throws FueraDeRangoException {
        // Crea un jugador
        Jugador jugador = new Jugador("Jugador1");

        // Crea una lista de cartas
        ArrayList<Carta> mano = new ArrayList<>();
        mano.add(new Carta(7, Figura.TREBOLES));
        mano.add(new Carta(3, Figura.DIAMANTES));

        // Establece la lista de cartas como la mano del jugador
        jugador.setMano(mano);

        // Verifica que la mano del jugador sea igual a la lista de cartas establecida
        assertEquals(mano, jugador.getMano());
    }

    @Test
    public void testSumarPuntuacion() {
        // Crea un jugador
        Jugador jugador = new Jugador("Jugador1");

        // Realiza la acción de sumar puntuación en el jugador
        jugador.sumarPuntuacion();

        // Verifica que la puntuación del jugador sea igual a 2
        assertEquals(2, jugador.getPuntuacion());
    }

    @Test
    public void testEmpate() {
        // Crea un jugador
        Jugador jugador = new Jugador("Jugador1");

        // Realiza la acción de empate en el jugador
        jugador.empate();

        // Verifica que la puntuación del jugador sea igual a 1
        assertEquals(1, jugador.getPuntuacion());
    }

    @Test
    public void testObtenerCartaJugador() throws FueraDeRangoException {
        // Crea un jugador y una lista de cartas
        Jugador jugador = new Jugador("Jugador1");
        ArrayList<Carta> mano = new ArrayList<>();
        mano.add(new Carta(2, Figura.PICAS));
        mano.add(new Carta(1, Figura.TREBOLES));
        jugador.setMano(mano);

        // Obtiene una carta específica del jugador (por ejemplo, la segunda carta)
        int indiceCarta = 1;
        Carta expResult = mano.get(indiceCarta - 1);
        Carta result = Jugador.obtenerCartaJugador(jugador, indiceCarta);

        // Verifica que la carta obtenida sea igual a la carta esperada
        assertEquals(expResult, result);

        // Verifica que la carta obtenida haya sido removida de la mano del jugador
        assertFalse(jugador.getMano().contains(result));
    }

    @Test
    public void testToString() {
        // Crea un jugador
        Jugador jugador = new Jugador("Jugador1");

        // Obtiene la representación en cadena de la mano del jugador
        String expResult = "Mano{" + jugador.getMano() + "}";
        String result = jugador.toString();

        // Verifica que la representación en cadena sea igual a la esperada
        assertEquals(expResult, result);
    }
}
