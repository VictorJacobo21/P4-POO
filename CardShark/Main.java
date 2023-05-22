import java.util.*;
public class Main {
    private static Jugador jugador1;
    private static Jugador jugador2;
    private static Jugador jugador3;
    private static Jugador jugador4;

    public static void main(String[] args) {
        int op, ct=0, i, c1 = 0, c2 = 0, c3 = 0, c4 = 0, rondas = 1;
        String n1, n2, n3, n4;
        Dado dado1 = new Dado();  
        Dado dado2 = new Dado();  
        Dado dado3 = new Dado();  
        Dado dado4 = new Dado();  
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenidos al juego de cartas Card Shark");
        System.out.println("Por favor, seleccione el modo de juego que desea jugar: ");
        System.out.println("[1] Juego clásico: Card Shark");
        System.out.println("[2] Variante del juego: Card Shark Extended for All");
        op = sc.nextInt();

        switch (op) {
            case 1:
                System.out.println("---Juego clásico---");
                System.out.println("Ingrese el nombre del jugador 1: ");
                sc.nextLine();
                n1 = sc.nextLine();
                jugador1 = new Jugador(n1);
                System.out.println("Ingrese el nombre del jugador 2: ");
                n2 = sc.nextLine();
                jugador2 = new Jugador(n2);
                System.out.println("Ingrese el nombre del jugador 3: ");
                n3 = sc.nextLine();
                jugador3 = new Jugador(n3);
                Baraja baraja = new Baraja();
                baraja.barajar();
                System.out.println("Comienza el juego.");

                while (!jugador1.getMano().isEmpty() && !jugador2.getMano().isEmpty() && !jugador3.getMano().isEmpty()) {
                    for (i = 1; i <= 3; i++) {
                        System.out.println("Jugador: " + i + " elige cuál carta deseas lanzar");
                        ct = sc.nextInt();
                        Jugador jugador = obtenerJugador(i);
                        Carta cartaElegida = Jugador.obtenerCartaJugador(jugador, ct);
                        if (cartaElegida != null) {
                            System.out.println("Cartas restantes: " + jugador.getMano().toString());
                            if (i == 1) {
                                c1 = cartaElegida.getValor();
                            } else if (i == 2) {
                                c2 = cartaElegida.getValor();
                            } else if (i == 3) {
                                c3 = cartaElegida.getValor();
                            }
                        }
                    }
                  if (c1 > c2 && c1 > c3){
                    System.out.println("EL JUGADOR " + jugador1.getId() + " GANA 2 PUNTOS");
                    jugador1.sumarPuntuacion();
                    System.out.println("Puntos: "+jugador1.getPuntuacion());
                  }
                    if (c2 > c1 && c2 > c3){
                    System.out.println("EL JUGADOR " + jugador2.getId() + " GANA 2 PUNTOS");
                    jugador2.sumarPuntuacion();
                    System.out.println("Puntos: "+jugador2.getPuntuacion());
                  }
                    if (c3 > c1 && c3 > c2){
                    System.out.println("EL JUGADOR " + jugador3.getId() + " GANA 2 PUNTOS");
                    jugador3.sumarPuntuacion();
                    System.out.println("Puntos: "+jugador3.getPuntuacion());
                  }
                    if (c1 == c2 || c1 == c3 || c2 == c3) {
                        System.out.println("DESEMPATE");
                        if (c1 == c2) {
                            System.out.println("Cartas restantes: " + jugador1.getMano().toString());
                            System.out.println("Jugador 1 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida1 = Jugador.obtenerCartaJugador(jugador1, ct);
                            System.out.println("Cartas restantes: " + jugador2.getMano().toString());
                            System.out.println("Jugador 2 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida2 = Jugador.obtenerCartaJugador(jugador2, ct);
                            if (cartaElegida1.compareTo(cartaElegida2) > 0) {
                                System.out.println("EL JUGADOR " + jugador1.getId() + " GANA 2 PUNTOS");
                              jugador1.sumarPuntuacion();
                              System.out.println("Puntos: "+jugador1.getPuntuacion());
                            } else if (cartaElegida1.compareTo(cartaElegida2) < 0) {
                                System.out.println("EL JUGADOR " + jugador2.getId() + " GANA 2 PUNTOS");
                              jugador2.sumarPuntuacion();
                              System.out.println("Puntos: "+jugador2.getPuntuacion());
                            }
                          else {
                              jugador1.empate();
                              jugador2.empate();
                          System.out.println("EMPATE NUEVAMENTE, PUNTOS: "+jugador1.getPuntuacion()+" y "+jugador2.getPuntuacion());
                        }
                        }
                           if (c1 == c3) {
                           System.out.println("Cartas restantes: " + jugador1.getMano().toString());
                           System.out.println("Jugador 1 elige cuál carta deseas lanzar");
                           ct = sc.nextInt();
                           Carta cartaElegida1 = Jugador.obtenerCartaJugador(jugador1, ct);
                           System.out.println("Cartas restantes: " + jugador3.getMano().toString());
                           System.out.println("Jugador 3 elige cuál carta deseas lanzar");
                           ct = sc.nextInt();
                           Carta cartaElegida3 = Jugador.obtenerCartaJugador(jugador3, ct);

                           if (cartaElegida1.compareTo(cartaElegida3) > 0) {
                           System.out.println("EL JUGADOR " + jugador1.getId() + " GANA 2 PUNTOS");
                            jugador1.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador1.getPuntuacion());
                          } 
                           else if (cartaElegida1.compareTo(cartaElegida3) < 0) {
                            System.out.println("EL JUGADOR " + jugador3.getId() + " GANA 2 PUNTOS");
                            jugador3.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador3.getPuntuacion());
                           }
                             else {
                              jugador1.empate();
                              jugador3.empate();
                              System.out.println("EMPATE NUEVAMENTE, PUNTOS: "+jugador1.getPuntuacion()+" y "+jugador3.getPuntuacion());
                             }
                           }
                      else if (c2 == c3) {
                            System.out.println("Cartas restantes: " + jugador2.getMano().toString());
                            System.out.println("Jugador 2 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida2 = Jugador.obtenerCartaJugador(jugador2, ct);
                            System.out.println("Cartas restantes: " + jugador3.getMano().toString());
                            System.out.println("Jugador 3 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida3 = Jugador.obtenerCartaJugador(jugador3, ct);
                            if (cartaElegida2.compareTo(cartaElegida3) > 0) {
                                System.out.println("EL JUGADOR " + jugador2.getId() + " GANA 2 PUNTOS");
                            jugador2.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador2.getPuntuacion());
                            } else if (cartaElegida2.compareTo(cartaElegida3) < 0) {
                                System.out.println("EL JUGADOR " + jugador3.getId() + " GANA 2 PUNTOS");
                            jugador3.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador3.getPuntuacion());
                            }
                             else {
                              jugador2.empate();
                              jugador3.empate();
                          System.out.println("EMPATE NUEVAMENTE, PUNTOS: "+jugador2.getPuntuacion()+" y "+jugador3.getPuntuacion());
                        }
                           }
                      if (c1 == c2 && c2 == c3){
                            System.out.println("Cartas restantes: " + 
                            jugador1.getMano().toString());
                            System.out.println("Jugador 1 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida1 = Jugador.obtenerCartaJugador(jugador1, ct);
                            System.out.println("Cartas restantes: " + jugador2.getMano().toString());
                            System.out.println("Jugador 2 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida2 = Jugador.obtenerCartaJugador(jugador2, ct);
                            System.out.println("Cartas restantes: " + jugador3.getMano().toString());
                            System.out.println("Jugador 3 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida3 = Jugador.obtenerCartaJugador(jugador3, ct);
                        if (cartaElegida1.compareTo(cartaElegida2) > 0 && cartaElegida1.compareTo(cartaElegida3) > 0) {
                            System.out.println("EL JUGADOR " + jugador1.getId() + " GANA 2 PUNTOS");
                            jugador1.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador1.getPuntuacion());
                      }
                       else if (cartaElegida2.compareTo(cartaElegida1) > 0 && cartaElegida2.compareTo(cartaElegida3) > 0) {
                            System.out.println("EL JUGADOR " + jugador2.getId() + " GANA 2 PUNTOS");
                            jugador2.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador2.getPuntuacion());
                      }
                        else if (cartaElegida3.compareTo(cartaElegida1) > 0 && cartaElegida3.compareTo(cartaElegida2) > 0) {
                            System.out.println("EL JUGADOR " + jugador3.getId() + " GANA 2 PUNTOS");
                            jugador3.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador3.getPuntuacion());
                      }
                        else {
                              jugador1.empate();
                              jugador2.empate();
                              jugador3.empate();
                          System.out.println("EMPATE NUEVAMENTE, PUNTOS: "+jugador1.getPuntuacion()+" , "+jugador2.getPuntuacion()+ " y " +jugador3.getPuntuacion());
                        }
                    }
                }
                }
                  if (jugador1.getPuntuacion() > jugador2.getPuntuacion() && jugador1.getPuntuacion() > jugador3.getPuntuacion()){
                    System.out.println("EL JUGADOR "+jugador1.getId()+ " GANA LA PARTIDA");
                  }
                  else if (jugador2.getPuntuacion() > jugador3.getPuntuacion() && jugador2.getPuntuacion() > jugador1.getPuntuacion()){
                    System.out.println("EL JUGADOR "+jugador2.getId()+ " GANA LA PARTIDA");
                  }
                  else {
                    System.out.println("EL JUGADOR "+jugador3.getId()+ " GANA LA PARTIDA");
                  }
                 System.out.println(jugador1.getId()+ " obtuvo: " +jugador1.getPuntuacion()+ "puntos");
                 System.out.println(jugador2.getId()+ " obtuvo: " +jugador2.getPuntuacion()+ "puntos");
                 System.out.println(jugador3.getId()+ " obtuvo: " +jugador3.getPuntuacion()+ "puntos");
                break;
            case 2:
                System.out.println("---Extended for All---");
                System.out.println("Ingrese el nombre del jugador 1: ");
                sc.nextLine();
                n1 = sc.nextLine();
                jugador1 = new Jugador(n1);
                System.out.println("Ingrese el nombre del jugador 2: ");
                n2 = sc.nextLine();
                jugador2 = new Jugador(n2);
                System.out.println("Ingrese el nombre del jugador 3: ");
                n3 = sc.nextLine();
                jugador3 = new Jugador(n3);
                System.out.println("Ingrese el nombre del jugador 4: ");
                n4 = sc.nextLine();
                jugador4 = new Jugador(n4);     
                Baraja baraja1 = new Baraja();
                Baraja baraja2 = new Baraja();
        
                baraja1.barajar();
                baraja2.barajar();
        
                ArrayList<Carta> cartasBaraja1 = baraja1.getCartas();
                ArrayList<Carta> cartasBaraja2 = baraja2.getCartas();
        
                Baraja barajaCombinada = new Baraja();
        
                for (Carta carta : cartasBaraja1) {
                barajaCombinada.agregarCarta(carta);
                }
        
                for (Carta carta : cartasBaraja2) {
                barajaCombinada.agregarCarta(carta);
                }
                barajaCombinada.barajar();
                 System.out.println("Comienza el juego.");
                  ArrayList<Carta> cartasJugador1 = jugador1.getMano();
                  ArrayList<Carta> cartasJugador2 = jugador2.getMano();
                  ArrayList<Carta> cartasJugador3 = jugador3.getMano();
                  ArrayList<Carta> cartasJugador4 = jugador4.getMano();
                  cartasJugador1.addAll(barajaCombinada.repartir(dado1.lanzar()));
                  cartasJugador2.addAll(barajaCombinada.repartir(dado2.lanzar()));
                  cartasJugador3.addAll(barajaCombinada.repartir(dado3.lanzar()));
                  cartasJugador4.addAll(barajaCombinada.repartir(dado4.lanzar()));
                  jugador1.setMano(cartasJugador1);
                  jugador2.setMano(cartasJugador2);
                  jugador3.setMano(cartasJugador3);
                  jugador4.setMano(cartasJugador4);
                  for(i = 1 ; i<=10 ; i++){
                    for (int j = 1; j <= 4; j++) {
                    System.out.println("Jugador " + j + ", elige qué carta deseas lanzar: ");
                    int cartaIndex = sc.nextInt();
                    Jugador jugador = obtenerJugador(j);
                    Carta cartaElegida = Jugador.obtenerCartaJugador(jugador, cartaIndex);
                    if (cartaElegida != null) {
                    jugador.removerCarta(cartaElegida);
                    System.out.println("Cartas restantes: " + jugador.getMano().toString());
                            if (j == 1) {
                                c1 = cartaElegida.getValor();
                            } else if (j == 2) {
                                c2 = cartaElegida.getValor();
                            } else if (j == 3) {
                                c3 = cartaElegida.getValor();
                            }
                              else if (j == 4) {
                                c4 = cartaElegida.getValor();
                              }
                    }
                    }
                    if (jugador1.getMano().isEmpty()){
                   cartasJugador1.addAll(barajaCombinada.repartir(dado1.lanzar()));
                   jugador1.setMano(cartasJugador1);
                 }
              if (jugador2.getMano().isEmpty()){
                 cartasJugador2.addAll(barajaCombinada.repartir(dado2.lanzar()));
                jugador2.setMano(cartasJugador2);
              }
               if (jugador3.getMano().isEmpty()){
                  cartasJugador3.addAll(barajaCombinada.repartir(dado3.lanzar()));
                  jugador3.setMano(cartasJugador3);
              } 
                    if (jugador4.getMano().isEmpty()){
                     cartasJugador4.addAll(barajaCombinada.repartir(dado4.lanzar())); 
                    jugador4.setMano(cartasJugador4);
                    }
                    if (c1 > c2 && c1 > c3 && c1 > c4){
                    System.out.println("EL JUGADOR " + jugador1.getId() + " GANA 2 PUNTOS");
                    jugador1.sumarPuntuacion();
                    System.out.println("Puntos: "+jugador1.getPuntuacion());
                  }
                     if (c2 > c1 && c2 > c3 && c2 > c4){
                    System.out.println("EL JUGADOR " + jugador2.getId() + " GANA 2 PUNTOS");
                    jugador2.sumarPuntuacion();
                    System.out.println("Puntos: "+jugador2.getPuntuacion());
                  }
                    if (c3 > c1 && c3 > c1 && c3 > c4){
                    System.out.println("EL JUGADOR " + jugador3.getId() + " GANA 2 PUNTOS");
                    jugador3.sumarPuntuacion();
                    System.out.println("Puntos: "+jugador3.getPuntuacion());
                  }
                    if (c4 > c1 && c4 > c2 && c4 > c3){
                    System.out.println("EL JUGADOR " + jugador4.getId() + " GANA 2 PUNTOS");
                    jugador4.sumarPuntuacion();
                    System.out.println("Puntos: "+jugador4.getPuntuacion());
                  }
             if (c1 == c2 || c1 == c3 || c2 == c3 || c4 == c1 || c4 == c2 || c4 == c3) {
                        System.out.println("DESEMPATE");
                        if (c1 == c2) {
                            System.out.println("Cartas restantes: " + jugador1.getMano().toString());
                            System.out.println("Jugador 1 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida1 = Jugador.obtenerCartaJugador(jugador1, ct);
                            System.out.println("Cartas restantes: " + jugador2.getMano().toString());
                            System.out.println("Jugador 2 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida2 = Jugador.obtenerCartaJugador(jugador2, ct);
                            if (cartaElegida1.compareTo(cartaElegida2) > 0) {
                                System.out.println("EL JUGADOR " + jugador1.getId() + " GANA 2 PUNTOS");
                              jugador1.sumarPuntuacion();
                              System.out.println("Puntos: "+jugador1.getPuntuacion());
                            } else if (cartaElegida1.compareTo(cartaElegida2) < 0) {
                                System.out.println("EL JUGADOR " + jugador2.getId() + " GANA 2 PUNTOS");
                              jugador2.sumarPuntuacion();
                              System.out.println("Puntos: "+jugador2.getPuntuacion());
                            }
                          else {
                              jugador1.empate();
                              jugador2.empate();
                          System.out.println("EMPATE NUEVAMENTE, PUNTOS: "+jugador1.getPuntuacion()+" y "+jugador2.getPuntuacion());
                        }
                        }
                           if (c1 == c3) {
                           System.out.println("Cartas restantes: " + jugador1.getMano().toString());
                           System.out.println("Jugador 1 elige cuál carta deseas lanzar");
                           ct = sc.nextInt();
                           Carta cartaElegida1 = Jugador.obtenerCartaJugador(jugador1, ct);
                           System.out.println("Cartas restantes: " + jugador3.getMano().toString());
                           System.out.println("Jugador 3 elige cuál carta deseas lanzar");
                           ct = sc.nextInt();
                           Carta cartaElegida3 = Jugador.obtenerCartaJugador(jugador3, ct);

                           if (cartaElegida1.compareTo(cartaElegida3) > 0) {
                           System.out.println("EL JUGADOR " + jugador1.getId() + " GANA 2 PUNTOS");
                            jugador1.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador1.getPuntuacion());
                          } 
                           else if (cartaElegida1.compareTo(cartaElegida3) < 0) {
                            System.out.println("EL JUGADOR " + jugador3.getId() + " GANA 2 PUNTOS");
                            jugador3.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador3.getPuntuacion());
                           }
                             else {
                              jugador1.empate();
                              jugador3.empate();
                              System.out.println("EMPATE NUEVAMENTE, PUNTOS: "+jugador1.getPuntuacion()+" y "+jugador3.getPuntuacion());
                             }
                           }
                      else if (c2 == c3) {
                            System.out.println("Cartas restantes: " + jugador2.getMano().toString());
                            System.out.println("Jugador 2 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida2 = Jugador.obtenerCartaJugador(jugador2, ct);
                            System.out.println("Cartas restantes: " + jugador3.getMano().toString());
                            System.out.println("Jugador 3 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida3 = Jugador.obtenerCartaJugador(jugador3, ct);
                            if (cartaElegida2.compareTo(cartaElegida3) > 0) {
                                System.out.println("EL JUGADOR " + jugador2.getId() + " GANA 2 PUNTOS");
                            jugador2.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador2.getPuntuacion());
                            } else if (cartaElegida2.compareTo(cartaElegida3) < 0) {
                                System.out.println("EL JUGADOR " + jugador3.getId() + " GANA 2 PUNTOS");
                            jugador3.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador3.getPuntuacion());
                            }
                             else {
                              jugador2.empate();
                              jugador3.empate();
                          System.out.println("EMPATE NUEVAMENTE, PUNTOS: "+jugador2.getPuntuacion()+" y "+jugador3.getPuntuacion());
                        }
                           }
                              if (c4 == c1) {
                           System.out.println("Cartas restantes: " + jugador4.getMano().toString());
                           System.out.println("Jugador 4 elige cuál carta deseas lanzar");
                           ct = sc.nextInt();
                           Carta cartaElegida4 = Jugador.obtenerCartaJugador(jugador4, ct);
                           System.out.println("Cartas restantes: " + jugador1.getMano().toString());
                           System.out.println("Jugador 1 elige cuál carta deseas lanzar");
                           ct = sc.nextInt();
                           Carta cartaElegida1 = Jugador.obtenerCartaJugador(jugador1, ct);

                           if (cartaElegida4.compareTo(cartaElegida1) > 0) {
                           System.out.println("EL JUGADOR " + jugador4.getId() + " GANA 2 PUNTOS");
                            jugador4.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador4.getPuntuacion());
                          } 
                           else if (cartaElegida4.compareTo(cartaElegida1) < 0) {
                            System.out.println("EL JUGADOR " + jugador1.getId() + " GANA 2 PUNTOS");
                            jugador1.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador1.getPuntuacion());
                           }
                           }
                               if (c4 == c2) {
                           System.out.println("Cartas restantes: " + jugador4.getMano().toString());
                           System.out.println("Jugador 4 elige cuál carta deseas lanzar");
                           ct = sc.nextInt();
                           Carta cartaElegida4 = Jugador.obtenerCartaJugador(jugador4, ct);
                           System.out.println("Cartas restantes: " + jugador2.getMano().toString());
                           System.out.println("Jugador 2 elige cuál carta deseas lanzar");
                           ct = sc.nextInt();
                           Carta cartaElegida2 = Jugador.obtenerCartaJugador(jugador2, ct);

                           if (cartaElegida4.compareTo(cartaElegida2) > 0) {
                           System.out.println("EL JUGADOR " + jugador4.getId() + " GANA 2 PUNTOS");
                            jugador4.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador4.getPuntuacion());
                          } 
                           else if (cartaElegida4.compareTo(cartaElegida2) < 0) {
                            System.out.println("EL JUGADOR " + jugador2.getId() + " GANA 2 PUNTOS");
                            jugador2.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador2.getPuntuacion());
                           }
                               }
                              if (c4 == c3) {
                           System.out.println("Cartas restantes: " + jugador4.getMano().toString());
                           System.out.println("Jugador 4 elige cuál carta deseas lanzar");
                           ct = sc.nextInt();
                           Carta cartaElegida4 = Jugador.obtenerCartaJugador(jugador4, ct);
                           System.out.println("Cartas restantes: " + jugador3.getMano().toString());
                           System.out.println("Jugador 3 elige cuál carta deseas lanzar");
                           ct = sc.nextInt();
                           Carta cartaElegida3 = Jugador.obtenerCartaJugador(jugador3, ct);

                           if (cartaElegida4.compareTo(cartaElegida3) > 0) {
                           System.out.println("EL JUGADOR " + jugador4.getId() + " GANA 2 PUNTOS");
                            jugador4.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador4.getPuntuacion());
                          } 
                           else if (cartaElegida4.compareTo(cartaElegida3) < 0) {
                            System.out.println("EL JUGADOR " + jugador3.getId() + " GANA 2 PUNTOS");
                            jugador3.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador3.getPuntuacion());
                           }
                           }
                      if (c1 == c2 && c2 == c3 && c3 == c4){
                            System.out.println("Cartas restantes: " + 
                            jugador1.getMano().toString());
                            System.out.println("Jugador 1 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida1 = Jugador.obtenerCartaJugador(jugador1, ct);
                            System.out.println("Cartas restantes: " + jugador2.getMano().toString());
                            System.out.println("Jugador 2 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida2 = Jugador.obtenerCartaJugador(jugador2, ct);
                            System.out.println("Cartas restantes: " + jugador3.getMano().toString());
                            System.out.println("Jugador 3 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida3 = Jugador.obtenerCartaJugador(jugador3, ct);
                            System.out.println("Cartas restantes: " + jugador4.getMano().toString());
                            System.out.println("Jugador 4 elige cuál carta deseas lanzar");
                            ct = sc.nextInt();
                            Carta cartaElegida4 = Jugador.obtenerCartaJugador(jugador4, ct);
                        if (cartaElegida1.compareTo(cartaElegida2) > 0 && cartaElegida1.compareTo(cartaElegida3) > 0) {
                            System.out.println("EL JUGADOR " + jugador1.getId() + " GANA 2 PUNTOS");
                            jugador1.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador1.getPuntuacion());
                      }
                       else if (cartaElegida2.compareTo(cartaElegida1) > 0 && cartaElegida2.compareTo(cartaElegida3) > 0) {
                            System.out.println("EL JUGADOR " + jugador2.getId() + " GANA 2 PUNTOS");
                            jugador2.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador2.getPuntuacion());
                      }
                        else if (cartaElegida3.compareTo(cartaElegida1) > 0 && cartaElegida3.compareTo(cartaElegida2) > 0) {
                            System.out.println("EL JUGADOR " + jugador3.getId() + " GANA 2 PUNTOS");
                            jugador2.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador3.getPuntuacion());
                      }
                          else if (cartaElegida4.compareTo(cartaElegida1) > 0 && cartaElegida4.compareTo(cartaElegida2) > 0 && cartaElegida4.compareTo(cartaElegida3) > 0) {
                            System.out.println("EL JUGADOR " + jugador4.getId() + " GANA 2 PUNTOS");
                            jugador4.sumarPuntuacion();
                            System.out.println("Puntos: "+jugador4.getPuntuacion());
                          }
                        else {
                              jugador1.empate();
                              jugador2.empate();
                              jugador3.empate();
                              jugador4.empate();
                          System.out.println("EMPATE NUEVAMENTE, PUNTOS: "+jugador1.getPuntuacion()+" , "+jugador2.getPuntuacion()+ " ," +jugador3.getPuntuacion()+ " y " +jugador4.getPuntuacion());
                          }
                    }
             }
             }
            if (jugador1.getPuntuacion() > jugador2.getPuntuacion() && jugador1.getPuntuacion() > jugador3.getPuntuacion() && jugador1.getPuntuacion() > jugador4.getPuntuacion()){
                    System.out.println("EL JUGADOR "+jugador1.getId()+ " GANA LA PARTIDA");
                  }
                  else if (jugador2.getPuntuacion() > jugador1.getPuntuacion() && jugador2.getPuntuacion() > jugador3.getPuntuacion() && jugador2.getPuntuacion() > jugador4.getPuntuacion())
            {
                    System.out.println("EL JUGADOR "+jugador2.getId()+ " GANA LA PARTIDA");
                  }
                  else if (jugador3.getPuntuacion() > jugador1.getPuntuacion() && jugador3.getPuntuacion() > jugador2.getPuntuacion() && jugador3.getPuntuacion() > jugador4.getPuntuacion()){
                    System.out.println("EL JUGADOR "+jugador3.getId()+ " GANA LA PARTIDA");
                  }
            else {
            System.out.println("EL JUGADOR "+jugador4.getId()+ " GANA LA PARTIDA");
                }
                 System.out.println(jugador1.getId()+ " obtuvo: " +jugador1.getPuntuacion()+ "puntos");
                 System.out.println(jugador2.getId()+ " obtuvo: " +jugador2.getPuntuacion()+ "puntos");
                 System.out.println(jugador3.getId()+ " obtuvo: " +jugador3.getPuntuacion()+ "puntos");
                 System.out.println(jugador4.getId()+ " obtuvo: " +jugador4.getPuntuacion()+ "puntos");
                break;
            default:
                System.out.println("Opción no válida");
                break;
    }
  }
    public static Jugador obtenerJugador(int indice) {
        switch (indice) {
            case 1:
                return jugador1;
            case 2:
                return jugador2;
            case 3:
                return jugador3;
            case 4:
                return jugador4;
            default:
                return null;
        }
    }
}