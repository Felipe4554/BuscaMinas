package Controlador;

import Modelo.Casilla;
import Modelo.CasillaAbiertaListener;
import Modelo.PartidaGanadaListener;
import Modelo.PartidaPerdidaListener;
import Modelo.TableroBuscaminas;
import java.util.List;

public class JuegoController {
    private TableroBuscaminas tablero;

    public JuegoController(int numFilas, int numColumnas, int numMinas) {
        tablero = new TableroBuscaminas(numFilas, numColumnas, numMinas);
    }

    public void seleccionarCasilla(int posFila, int posColumna) {
        tablero.seleccionarCasilla(posFila, posColumna);
    }

    public List<Casilla> obtenerCasillasConMinas() {
        return tablero.obtenerCasillasConMinas();
    }

    public boolean partidaGanada() {
        return tablero.partidaGanada();
    }
    
    public boolean partidaPerdida() {
        return tablero.partidaPerdida();
    }

    public void setCasillaAbiertaListener(CasillaAbiertaListener listener) {
        tablero.setCasillaAbiertaListener(listener);
    }

    public void setPartidaPerdidaListener(PartidaPerdidaListener listener) {
        tablero.setPartidaPerdidaListener(listener);
    }

    public void setPartidaGanadaListener(PartidaGanadaListener listener) {
        tablero.setPartidaGanadaListener(listener);
    }
}

