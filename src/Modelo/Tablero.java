package Modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tablero implements SujetoObservable {

    private Casilla[][] casillas;
    private int numFilas;
    private int numColumnas;
    private int numMinas;
    private int numCasillasAbiertas;
    private boolean juegoTerminado;

    private List<TableroObserver> observadores = new ArrayList<>();

    public Tablero(int numFilas, int numColumnas, int numMinas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;
        this.inicializarCasillas();
    }

    public void inicializarCasillas() {
        casillas = new Casilla[this.numFilas][this.numColumnas];

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
                    continue;
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

    public void escogerCasilla(int posFila, int posColumna) {
        notificarCasillaAbierta(this.casillas[posFila][posColumna]);

        if (this.casillas[posFila][posColumna].isMina()) {
            notificarPartidaPerdida(obtenerCasillasConMinas());
        } else if (this.casillas[posFila][posColumna].getNumMinasAlrededor() == 0) {
            marcarCasillaAbierta(posFila, posColumna);
            List<Casilla> casillasAlrededor = obtenerCasillasAlrededor(posFila, posColumna);
            for (Casilla casilla : casillasAlrededor) {
                if (!casilla.isAbierta()) {
                    escogerCasilla(casilla.getFila(), casilla.getColumna());
                }
            }
        } else {
            marcarCasillaAbierta(posFila, posColumna);
        }

        if (partidaGanada()) {
            notificarPartidaGanada(obtenerCasillasConMinas());
        }
    }

    public boolean partidaGanada() {
        return numCasillasAbiertas >= (numFilas * numColumnas) - numMinas;
    }

    public boolean partidaPerdida() {
        return juegoTerminado;
    }

    @Override
    public void registrarObservador(TableroObserver observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(TableroObserver observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (TableroObserver observador : observadores) {
            observador.actualizar(this);
        }
    }

    public void notificarCasillaAbierta(Casilla casilla) {
        for (TableroObserver observador : observadores) {
            observador.casillaAbierta(casilla);
        }
    }

    public void notificarPartidaPerdida(List<Casilla> casillas) {
        for (TableroObserver observador : observadores) {
            observador.partidaPerdida(casillas);
        }
    }

    public void notificarPartidaGanada(List<Casilla> casillas) {
        for (TableroObserver observador : observadores) {
            observador.partidaGanada(casillas);
        }
    }

}
