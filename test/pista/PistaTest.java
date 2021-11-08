package pista;

import avion.AvionSimple;
import org.junit.Before;
import org.junit.Test;
import avion.Avion;
import copControl.Mapa;
import copControl.Posicion;
import java.util.List;
import java.util.ArrayList;




import static org.junit.Assert.*;



public class PistaTest {
    Avion avion;
    Mapa mapa;
    Pista pista;

    @Before
    public void setUp() throws Exception {
        //Radio aterrizaje avion = 10
        //Radio aterrizado pista = 15
        Posicion posicionPista = new Posicion(0,0);
        Posicion posicionAvion = new Posicion(0,26);

        List<Pista> pistas = new ArrayList<Pista>();
        pista = new PistaSimple(posicionPista);
        pistas.add(pista);
        mapa = new Mapa(pistas);
        avion = new AvionSimple(posicionAvion, posicionPista ,mapa);



    }

    @Test

    public void fueraDeRadioaterrizaje() {
        assertFalse(pista.estaEnZonaAterrizaje(avion));
    }

    @Test
    public void avanzaDentroDeRadioAterrizaje() {
        avion.avanzar();
        assertTrue(pista.estaEnZonaAterrizaje(avion));
    }

}