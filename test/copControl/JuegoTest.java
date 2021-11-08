package copControl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pista.Pista;
import pista.PistaSimple;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JuegoTest {
    Nivel nivelActual;
    Nivel nivelSiguiente;
    Pista pista;
    Jugador jugador;
    List<Nivel> niveles;
    Mapa mapa;
    Dificultad dificultad, dificultadSiguiente;
    Juego juego;

    @Before
    public void setUp() throws Exception {
        Posicion posicionPista = new Posicion(30,30);
        List<Pista> pistas = new ArrayList<Pista>();
        pista = new PistaSimple(posicionPista);
        pistas.add(pista);
        mapa = new Mapa(pistas);

        dificultad = new Dificultad(4,1,1);
        dificultadSiguiente = new Dificultad(5,5,2);

        nivelActual = new Nivel(mapa, dificultad);
        nivelSiguiente = new Nivel(mapa,dificultadSiguiente);

        niveles = new ArrayList<Nivel>();
        niveles.add(nivelActual);
        niveles.add(nivelSiguiente);

        jugador = new Jugador("walter");

        juego = new Juego(jugador, niveles);

    }

    @Test
    public void generacionUnAvion() {
        juego.colocarAvion();
        juego.colocarAvion();
        juego.vivir();
        juego.colocarAvion();
        assertTrue(mapa.getAvionesEnAire().size() == 1);

    }

}