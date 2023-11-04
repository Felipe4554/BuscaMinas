/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Casilla;
import Modelo.CasillaAbiertaListener;
import Modelo.PartidaGanadaListener;
import Modelo.PartidaPerdidaListener;
import Modelo.TableroBuscaminas;
import java.util.List;

/**
 *
 * @author ´Felipe Chacón
 */
public class Juego {
    private TableroBuscaminas tablero;

    public Juego(int numFilas, int numColumnas, int numMinas) {
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

