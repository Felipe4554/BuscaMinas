package Modelo;

import java.util.LinkedList;
import java.util.List;

public class TableroBuscaminas {

    private Casilla[][] casillas;
    private int numFilas;
    private int numColumnas;
    private int numMinas;
    private int numCasillasAbiertas;
    private boolean juegoTerminado;

    private CasillaAbiertaListener casillaAbiertaListener;
    private PartidaPerdidaListener partidaPerdidaListener;
    private PartidaGanadaListener partidaGanadaListener;

    public TableroBuscaminas(int numFilas, int numColumnas, int numMinas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;
        this.inicializarCasillas();
    }

    public void inicializarCasillas() {
        casillas = new Casilla[this.numFilas][this.numColumnas];

        // Crear casilla vacía en la primera posición
        casillas[0][0] = new Casilla(0, 0);

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (i != 0 || j != 0) {
                    casillas[i][j] = new Casilla(i, j);
                }
            }
        }

        generarMinas();
    }

    public void generarMinas() {
        int minasGeneradas = 0;
        while (minasGeneradas != numMinas) {
            int posTmpFila = (int) (Math.random() * casillas.length);
            int posTmpColumna = (int) (Math.random() * casillas[0].length);
            if (!casillas[posTmpFila][posTmpColumna].isMina()) {
                casillas[posTmpFila][posTmpColumna].setMina(true);
                minasGeneradas++;
            }
        }
        actualizarNumeroMinasAlrededor();
    }

    public void actualizarNumeroMinasAlrededor() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].isMina()) {
                    List<Casilla> casillasAlrededor = obtenerCasillasAlrededor(i, j);
                    casillasAlrededor.forEach((c) -> c.incrementarNumeroMinasAlrededor());
                }
            }
        }
    }

    private List<Casilla> obtenerCasillasAlrededor(int posFila, int posColumna) {
        List<Casilla> listaCasillas = new LinkedList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue; // Ignorar la casilla actual
                }
                int tmpPosFila = posFila + i;
                int tmpPosColumna = posColumna + j;

                if (tmpPosFila >= 0 && tmpPosFila < this.casillas.length
                        && tmpPosColumna >= 0 && tmpPosColumna < this.casillas[0].length) {
                    listaCasillas.add(this.casillas[tmpPosFila][tmpPosColumna]);
                }
            }
        }
        return listaCasillas;
    }

    public void marcarCasillaAbierta(int posFila, int posColumna) {
        if (!this.casillas[posFila][posColumna].isAbierta()) {
            numCasillasAbiertas++;
            this.casillas[posFila][posColumna].setAbierta(true);
        }
    }

    public List<Casilla> obtenerCasillasConMinas() {
        List<Casilla> casillasConMinas = new LinkedList<>();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].isMina()) {
                    casillasConMinas.add(casillas[i][j]);
                }
            }
        }
        return casillasConMinas;
    }

    public void seleccionarCasilla(int posFila, int posColumna) {
        casillaAbiertaListener.casillaAbierta(this.casillas[posFila][posColumna]);

        if (this.casillas[posFila][posColumna].isMina()) {
            partidaPerdidaListener.partidaPerdida(obtenerCasillasConMinas());
        } else if (this.casillas[posFila][posColumna].getNumMinasAlrededor() == 0) {
            marcarCasillaAbierta(posFila, posColumna);
            List<Casilla> casillasAlrededor = obtenerCasillasAlrededor(posFila, posColumna);
            for (Casilla casilla : casillasAlrededor) {
                if (!casilla.isAbierta()) {
                    seleccionarCasilla(casilla.getPosFila(), casilla.getPosColumna());
                }
            }
        } else {
            marcarCasillaAbierta(posFila, posColumna);
        }

        if (partidaGanada()) {
            partidaGanadaListener.partidaGanada(obtenerCasillasConMinas());
        }
    }

    public boolean partidaGanada() {
        return numCasillasAbiertas >= (numFilas * numColumnas) - numMinas;
    }

    public boolean partidaPerdida() {
        return juegoTerminado && casillaAbiertaListener != null && partidaPerdidaListener != null;
    }

    public void setCasillaAbiertaListener(CasillaAbiertaListener listener) {
        this.casillaAbiertaListener = listener;
    }

    public void setPartidaPerdidaListener(PartidaPerdidaListener listener) {
        this.partidaPerdidaListener = listener;
    }

    public void setPartidaGanadaListener(PartidaGanadaListener listener) {
        this.partidaGanadaListener = listener;
    }

}
