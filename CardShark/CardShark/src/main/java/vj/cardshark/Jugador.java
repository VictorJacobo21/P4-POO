package vj.cardshark;
import java.util.ArrayList;
public class Jugador {
  private String id;
  private int puntuacion;
  private ArrayList<Carta> mano = new ArrayList<>();

  public Jugador(String id) {
    this.id = id;
    puntuacion = 0;
    generarMano();
  }
 
  public void removerCarta(Carta carta) {
    mano.remove(carta);
}


  public void generarMano() {
    Baraja b = new Baraja();
    b.barajar();
    mano = b.repartir(5);
    System.out.println(mano);
    int negras = 0;
    int rojas = 0;
    for (Carta carta : mano) {
      if (carta.getColor() == Color.NEGRO)
        negras++;
      else
        rojas++;
    }
    System.out.println("Negras: " + negras + " Rojas: " + rojas);
  }

  public String getId() {
    return id;
  }

  public ArrayList<Carta> getMano() {
    return mano;
}
  public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }
public void sumarPuntuacion(){
  puntuacion += 2;
}
  public int getPuntuacion(){
    return puntuacion;
  }
  public void empate(){
    puntuacion += 1;
  }
  
  public static Carta obtenerCartaJugador(Jugador jugador, int indiceCarta) {
    if (indiceCarta >= 1 && indiceCarta <= jugador.getMano().size()) {
      Carta cartaElegida = jugador.getMano().get(indiceCarta - 1);
      jugador.getMano().remove(indiceCarta - 1);
      System.out.println("El jugador " + jugador.getId() + " ha tirado la carta: " + cartaElegida.toString());
      return cartaElegida;
    } else {
      System.out.println("El índice de la carta seleccionada no es válido.");
      return null;
    }
  }


  @Override
  public String toString() {
    return "Mano{" + mano + "}";
  }
}

